package com.dleonisa.dleonisa.back_end.repository;

import com.dleonisa.dleonisa.back_end.modelo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRole extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
