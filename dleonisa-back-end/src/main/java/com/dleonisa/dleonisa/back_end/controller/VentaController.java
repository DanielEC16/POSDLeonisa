package com.dleonisa.dleonisa.back_end.controller;

import com.dleonisa.dleonisa.back_end.modelo.dto.DetalleVentaDTO;
import com.dleonisa.dleonisa.back_end.modelo.dto.VentaDTO;
import com.dleonisa.dleonisa.back_end.modelo.entity.Venta;
import com.dleonisa.dleonisa.back_end.service.DetalleVentaService;
import com.dleonisa.dleonisa.back_end.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping("/listar")
    public List<VentaDTO> listarVentas(){
        return ventaService.listarVentas();
    }

    @GetMapping("/{id}/detalles")
    public List<DetalleVentaDTO> listarDetalleVenta(@PathVariable Long id){
        return detalleVentaService.listarDetalleUnaVenta(id);
    }
}
