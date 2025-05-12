package com.dleonisa.dleonisa.back_end.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product producto;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio_unitario")
    private double precioUnitario;
    @Column(name = "sub_total")
    private double subtotal;
}
