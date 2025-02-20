package com.insy2s.ecommerce_backend.model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record RegistrationRequest (
        @Email(message = "Votre email doit être valide") String email,
        @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[\\W_]).{8,}$",
                message = "Votre mot de passe doit contenir au moins 8 caractères dont " +
                        "une majuscule, un chiffre et un caractère spécial")
        String password
){
}
