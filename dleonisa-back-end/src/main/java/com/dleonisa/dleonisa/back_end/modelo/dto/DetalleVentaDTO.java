package com.dleonisa.dleonisa.back_end.modelo.dto;

public record DetalleVentaDTO(String producto_nombre,
                              double precio_unitario,
                              int cantidad,
                              double sub_total) {
}
