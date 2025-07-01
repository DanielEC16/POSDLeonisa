package com.dleonisa.dleonisa.back_end.modelo.dto;

import com.dleonisa.dleonisa.back_end.modelo.entity.Clients;
import jakarta.validation.constraints.NotNull;

public record ClientDTO(
        Long id,
        String nombre,
        String apellido,
        @NotNull String dni
) {
}
