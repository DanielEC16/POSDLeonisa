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
@Table(name = "sabores")
public class Flavors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    @ManyToMany(mappedBy = "sabores")
    private List<Product> products = new ArrayList<>();
}
