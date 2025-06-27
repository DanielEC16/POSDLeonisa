package com.dleonisa.dleonisa.back_end.modelo.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonPropertyOrder({
        "id",
        "nombre",
        "descripcion",
        "precio",
        "categoria",
        "sabores"
})
@Entity
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nombre",nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio",nullable = false, columnDefinition = "DECIMAL(5,2) DEFAULT 0.50")
    private double precio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categori_id",nullable = false)
    private Category categoria;

    @ManyToMany
    @JoinTable(
            name = "productos_sabores",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_sabor")
    )
    private List<Flavors> sabores = new ArrayList<>();
}
