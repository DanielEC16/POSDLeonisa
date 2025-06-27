package com.dleonisa.dleonisa.back_end.modelo.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record AuthRequest(@NotBlank String username,
                          @NotBlank String password) {
}
