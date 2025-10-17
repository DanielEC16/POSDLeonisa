package com.dleonisa.dleonisa.back_end.modelo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "venta_id")
    @JsonBackReference
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio_unitario")
    private double precioUnitario;
    @Column(name = "sub_total")
    private double subtotal;
}
