package com.insy2s.ecommerce_backend.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegistrationResponse(
        @JsonProperty("access_token")
        String accessToken,
        String username,
        String email
) {
}
