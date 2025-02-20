package com.insy2s.ecommerce_backend.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthenticationResponse(
        @JsonProperty("access_token")
        String accessToken
) {
}
