package com.dleonisa.dleonisa.back_end.repository;

import com.dleonisa.dleonisa.back_end.modelo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUser extends JpaRepository <Users,Long> {
    Optional<Users> findUserByUsuario(String usuario);
}
