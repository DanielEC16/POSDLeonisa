package com.dleonisa.dleonisa.back_end.modelo.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLogin(@NotBlank String username,
                        @NotBlank String password ) {
}
