package com.dleonisa.dleonisa.back_end.modelo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CategoryDTO(
        Long id,
        String nombre
) {
}
