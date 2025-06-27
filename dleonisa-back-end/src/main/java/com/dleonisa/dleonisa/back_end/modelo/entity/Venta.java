package com.dleonisa.dleonisa.back_end.modelo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clients cliente;
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Users vendedor;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "total")
    private double total;
}
