package com.dleonisa.dleonisa.back_end.modelo.dto.auth;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AuthCreateUser(@NotBlank String username,
                             @NotBlank String password,
                             @NotBlank String nombre,
                             @NotBlank String apellido,
                             @NotBlank String dni,
                             @Valid String role) {
}
