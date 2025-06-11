package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.Flavors;
import com.dleonisa.dleonisa.back_end.modelo.Product;
import com.dleonisa.dleonisa.back_end.modelo.dto.ProductDTO;
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

    public List<ProductDTO> listarProducts(){
        List<Product> products = iProduct.findAll();
        return products.stream()
                .map(product -> new ProductDTO(
                        product.getNombre(),
                        product.getDescripcion(),
                        product.getPrecio(),
                        product.getCategoria().getNombre(),
                        product.getSabores().stream()
                                .map(Flavors::getNombre)
                                .toList()
                ))
                .toList();
    }
    public  ProductDTO obtenerPorId(Long id){
        Product product = iProduct.findById(id)
                .orElseThrow(()->new RuntimeException("Producto no Encontrado"));

        return new ProductDTO(
                product.getNombre(),
                product.getDescripcion(),
                product.getPrecio(),
                product.getCategoria().getNombre(),
                product.getSabores().stream()
                        .map(Flavors::getNombre)
                        .toList()
        );
    }
    public Page<ProductDTO> listarPaginable(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = iProduct.findAll(pageable);
        return productPage.map(product -> new ProductDTO(
                product.getNombre(),
                product.getDescripcion(),
                product.getPrecio(),
                product.getCategoria().getNombre(),
                product.getSabores().stream()
                        .map(Flavors::getNombre)
                        .toList()
        ));
    }

}
