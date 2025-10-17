package com.dleonisa.dleonisa.back_end.repository;

import com.dleonisa.dleonisa.back_end.modelo.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleVenta extends JpaRepository<DetalleVenta,Long> {
    List<DetalleVenta> findByVentaId(Long ventaId);
}
