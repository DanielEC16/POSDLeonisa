package com.dleonisa.dleonisa.back_end.modelo.dto;

import com.dleonisa.dleonisa.back_end.modelo.entity.Role;

public record UsersDTO(
        String nombre,
        String apellido,
        String dni,
        String rol
) {
}
