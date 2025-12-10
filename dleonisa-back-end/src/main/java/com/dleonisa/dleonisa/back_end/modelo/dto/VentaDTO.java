package com.dleonisa.dleonisa.back_end.modelo.dto;

import java.time.LocalDateTime;
import java.util.List;

public record VentaDTO(Long id,
                       LocalDateTime fecha_venta,
                       String metodo_pago,
                       double total,
                       String cliente_dni,
                       String cliente_nombre,
                       String vendedor){
}
