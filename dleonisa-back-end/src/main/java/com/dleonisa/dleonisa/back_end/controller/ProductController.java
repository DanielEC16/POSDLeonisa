package com.dleonisa.dleonisa.back_end.controller;

import com.dleonisa.dleonisa.back_end.modelo.dto.product.ProductDTO;
import com.dleonisa.dleonisa.back_end.modelo.entity.Producto;
import com.dleonisa.dleonisa.back_end.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/listarTodo")
    public List<Producto> listarProductos(){
        return productService.listarProductos();
    }

    @GetMapping("/buscar-{codigo}")
    public ResponseEntity<?> buscarPorCodigo(@PathVariable String codigo){
        Producto p = productService.buscarPorCodigo(codigo);
        if(p==null|| p.getStock()==0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }
}
