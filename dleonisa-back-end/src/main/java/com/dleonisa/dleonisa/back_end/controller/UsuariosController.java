package com.dleonisa.dleonisa.back_end.controller;

import com.dleonisa.dleonisa.back_end.modelo.dto.UsersDTO;
import com.dleonisa.dleonisa.back_end.service.UsersService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsersDTO>> listarUsuarios(){
        List<UsersDTO> usersDTOS = usersService.listarUsuarios();
        return  ResponseEntity.ok(usersDTOS);
    }
}
