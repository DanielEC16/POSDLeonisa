package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.entity.Producto;
import com.dleonisa.dleonisa.back_end.modelo.dto.product.ProductDTO;
import com.dleonisa.dleonisa.back_end.repository.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProduct iProduct;

    public List<Producto> listarProductos(){
        return iProduct.findAll().stream()
                .filter(Producto::getEstado)
                .toList();
    }

    public Producto buscarPorCodigo(String codProd){
        return iProduct.findByCodigo(codProd).orElse(null);
    }
}
