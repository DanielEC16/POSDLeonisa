package com.dleonisa.dleonisa.back_end.repository;

import com.dleonisa.dleonisa.back_end.modelo.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICliente extends JpaRepository<Clients,Long> {
    //Existe el DNi (T or F)
    boolean existsByDni(String dni);
    //Retornamos todo el objeto cliente de acuerdo a su dni
    Optional<Clients> findByDni(String dni);
}
