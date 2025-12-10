package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.dto.DetalleVentaDTO;
import com.dleonisa.dleonisa.back_end.modelo.dto.VentaDTO;
import com.dleonisa.dleonisa.back_end.modelo.entity.Venta;
import com.dleonisa.dleonisa.back_end.repository.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class VentaService {
    @Autowired
    private IVenta iVenta;

    public List<VentaDTO> listarVentas(){
        List<Venta> ventasList = iVenta.findAll();
        return ventasList.stream()
                .map(venta -> new VentaDTO(
                        venta.getId(),
                        venta.getFechaCreacion(),
                        venta.getMetodoDePago().name(),
                        venta.getTotal(),
                        venta.getCliente().getDni(),
                        venta.getCliente().getNombre()+" "+venta.getCliente().getApellido(),
                        venta.getVendedor().getNombre()+" "+venta.getVendedor().getApellido()
                )).toList();
    }
}
