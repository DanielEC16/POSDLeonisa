package com.dleonisa.dleonisa.back_end.modelo.dto;

import java.util.List;

public record ProductDTO(
        String nombre,
        String descripcion,
        Double precio,
        String categoria,
        List<String> sabores
) {
}
