package com.dleonisa.dleonisa.back_end.controller;

import com.dleonisa.dleonisa.back_end.modelo.entity.DetalleVenta;
import com.dleonisa.dleonisa.back_end.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalle-venta")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping("/listar")
    public List<DetalleVenta> listarDetalleVentas(){
        return detalleVentaService.listarDetalle();
    }


}
