package com.insy2s.ecommerce_backend.security;

import com.insy2s.ecommerce_backend.exceptions.InvalidCredentialsException;
import com.insy2s.ecommerce_backend.exceptions.ResourceAlreadyExistsException;
import com.insy2s.ecommerce_backend.model.DTO.AuthenticationRequest;
import com.insy2s.ecommerce_backend.model.DTO.AuthenticationResponse;
import com.insy2s.ecommerce_backend.model.DTO.RegistrationRequest;
import com.insy2s.ecommerce_backend.model.DTO.RegistrationResponse;
import com.insy2s.ecommerce_backend.model.entities.Role;
import com.insy2s.ecommerce_backend.model.entities.User;
import com.insy2s.ecommerce_backend.model.repositories.IRoleRepository;
import com.insy2s.ecommerce_backend.model.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleRepository roleRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public RegistrationResponse registerUser(RegistrationRequest registrationRequest) {

        Optional<User> existingUser = userRepository.findByEmail(registrationRequest.email());
        if (existingUser.isPresent()) {
            throw new ResourceAlreadyExistsException("Il existe déjà un utilisateur avec cette adresse e-mail");
        }

        User user = new User();
        user.setEmail(registrationRequest.email());
        user.setPassword(passwordEncoder.encode(registrationRequest.password()));
        Optional<Role> role = roleRepository.findByName("ROLE_USER");
        role.ifPresent(user::setRole);
        userRepository.save(user);
        final String token = jwtService.generateToken(user);

        return new RegistrationResponse(token, user.getEmail(), user.getRole().getName());
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        try {
            final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    request.email(),
                    request.password()
            );
            User user = userRepository.findByEmail(request.email()).orElseThrow(() -> new UsernameNotFoundException("Pas d'utilisateur enregistré avec cet email"));
            authenticationManager.authenticate(authenticationToken);
            final String token = jwtService.generateToken(user);
            return new AuthenticationResponse(token);

        } catch (AuthenticationException e) {

            throw new InvalidCredentialsException("Vos identifiants sont invalides");
        }
    }
}
