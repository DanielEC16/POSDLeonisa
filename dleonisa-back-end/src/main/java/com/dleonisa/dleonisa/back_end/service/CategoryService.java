package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.dto.CategoryDTO;
import com.dleonisa.dleonisa.back_end.modelo.entity.Category;
import com.dleonisa.dleonisa.back_end.repository.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ICategory iCategory;

    //Lisatdo de todos las categorias registradas
    public List<CategoryDTO> listarCategorias(){
        List<Category> categorys = iCategory.findAll();
        return categorys.stream()
                .map(category -> new CategoryDTO(
                        null,
                        category.getNombre()
                )).toList();
    }

    //Guardando una categgoria
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        if (iCategory.existsByNombre(categoryDTO.nombre())){
            throw new IllegalArgumentException("La categoria ya existe");
        }
        Category category = new Category();
        category.setNombre(categoryDTO.nombre());
        Category saved = iCategory.save(category);
        return new CategoryDTO(null,saved.getNombre());
    }

    //Cambiando valores de una categoria
    public CategoryDTO updateCategory(CategoryDTO categoryDTO){
        if (categoryDTO.id()==null){
            throw new IllegalArgumentException("El ID no puede ser nulo para actualizar");
        }
        Category category = iCategory.findById(categoryDTO.id())
                .orElseThrow(()-> new NoSuchElementException("Categoria no encotrada"));

        Optional<Category> exist = iCategory.findByNombre(categoryDTO.nombre());
        if (exist.isPresent() && !exist.get().getId().equals(categoryDTO.id())){
            throw new IllegalArgumentException("Ese nombre ya esta en uso por otra categoria");
        }
        category.setNombre(categoryDTO.nombre());
        Category actualizada = iCategory.save(category);
        return new CategoryDTO(actualizada.getId(),actualizada.getNombre());
    }
}
