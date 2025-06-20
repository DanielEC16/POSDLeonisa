package com.dleonisa.dleonisa.back_end.modelo.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AuthCreateUser(@NotBlank String username,
                             @NotBlank String password,
                             @Valid AuthCreateRole roleRequest) {
}
