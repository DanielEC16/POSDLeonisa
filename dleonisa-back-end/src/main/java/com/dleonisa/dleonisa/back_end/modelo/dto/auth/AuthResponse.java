package com.dleonisa.dleonisa.back_end.modelo.dto.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "username",
        "message",
        "jwt"
})
public record AuthResponse(String username,
                           String message,
                           String jwt) {

}