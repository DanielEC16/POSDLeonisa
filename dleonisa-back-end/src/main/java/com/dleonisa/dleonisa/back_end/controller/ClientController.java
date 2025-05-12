package com.dleonisa.dleonisa.back_end.controller;

import com.dleonisa.dleonisa.back_end.modelo.dto.ClientDTO;
import com.dleonisa.dleonisa.back_end.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/listar")
    public ResponseEntity<List<ClientDTO>> listarClientes(){
        List<ClientDTO> clientDTOS = clientService.listarClientes();
        return ResponseEntity.ok(clientDTOS);
    }
}
