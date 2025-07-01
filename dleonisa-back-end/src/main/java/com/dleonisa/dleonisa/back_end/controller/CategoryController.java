package com.dleonisa.dleonisa.back_end.controller;

import com.dleonisa.dleonisa.back_end.modelo.dto.CategoryDTO;
import com.dleonisa.dleonisa.back_end.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listarTodo")
    public ResponseEntity<List<CategoryDTO>> listarCategorys(){
        List<CategoryDTO> categoryDTOS = categoryService.listarCategorias();
        return ResponseEntity.ok(categoryDTOS);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> crearCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO categoryNew = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(categoryNew);
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryDTO> actualizarCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO actualizado = categoryService.updateCategory(categoryDTO);
        return ResponseEntity.ok(actualizado);
    }

}
