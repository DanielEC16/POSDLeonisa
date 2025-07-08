package com.dleonisa.dleonisa.back_end.modelo.dto.client;

import jakarta.validation.constraints.NotNull;

public record ClientDTO(
        Long id,
        String nombre,
        String apellido,
        @NotNull String dni
) {
}
