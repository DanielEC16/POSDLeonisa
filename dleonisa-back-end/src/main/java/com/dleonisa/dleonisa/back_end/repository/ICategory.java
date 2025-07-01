package com.dleonisa.dleonisa.back_end.repository;

import com.dleonisa.dleonisa.back_end.modelo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategory extends JpaRepository<Category,Long> {
    //Retorna todo el objeto categoria
    Optional<Category> findByNombre(String nombre);
    //Solo te dice si existe o no
    boolean existsByNombre(String nombre);
}
