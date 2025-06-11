package com.dleonisa.dleonisa.back_end.controller;

import com.dleonisa.dleonisa.back_end.modelo.dto.ProductDTO;
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
    public ResponseEntity<List<ProductDTO>> listarProducts(){
        List<ProductDTO> productDTOS = productService.listarProducts();
        return ResponseEntity.ok(productDTOS);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<ProductDTO> obtenerPorId(@PathVariable Long id){
        ProductDTO productDTO = productService.obtenerPorId(id);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<ProductDTO>> listarProductPaginados(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Page<ProductDTO> productDTO = productService.listarPaginable(page, size);
        return ResponseEntity.ok(productDTO);
    }
}
