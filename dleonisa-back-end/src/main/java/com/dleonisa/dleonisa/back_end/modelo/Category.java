package com.dleonisa.dleonisa.back_end.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "nombre" ,nullable = false,columnDefinition = "CHAR(10)")
    private String nombre;
    @JsonIgnore
    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
    private List<Product> productos = new ArrayList<>();

}
