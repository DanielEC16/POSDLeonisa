package com.dleonisa.dleonisa.back_end.repository;

import com.dleonisa.dleonisa.back_end.modelo.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliente extends JpaRepository<Clients,Long> {
}
