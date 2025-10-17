package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.dto.DetalleVentaDTO;
import com.dleonisa.dleonisa.back_end.modelo.entity.DetalleVenta;
import com.dleonisa.dleonisa.back_end.repository.IDetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {
    @Autowired
    private IDetalleVenta iDetalleVenta;

    public List<DetalleVenta> listarDetalle(){
        return iDetalleVenta.findAll();
    }

    public List<DetalleVentaDTO> listarDetalleUnaVenta(Long id){
        return iDetalleVenta.findByVentaId(id).stream()
                .map(detalleVenta -> new DetalleVentaDTO(
                        detalleVenta.getProducto().getNombre(),
                        detalleVenta.getPrecioUnitario(),
                        detalleVenta.getCantidad(),
                        detalleVenta.getSubtotal()
                )).toList();
    }
}
