package com.dleonisa.dleonisa.back_end.modelo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Users vendedor;
    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private MetodoDePago metodoDePago;
    @Column(name = "total")
    private double total;
    @Column(name = "fecha_creacion", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleVenta> detalles;

}
