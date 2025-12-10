package com.dleonisa.dleonisa.back_end.modelo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "cod_prod",nullable = false,unique = true,length = 10)
    private String codigo;

    @Column(name = "nombre",nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio",nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "stock")
    private int stock;

    @Column(name = "estado")
    private Boolean estado = true;

    @Column(name = "fecha_creacion", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime fechaCreacion;

}
