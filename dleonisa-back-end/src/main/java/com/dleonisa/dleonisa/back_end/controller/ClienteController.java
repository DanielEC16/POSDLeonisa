package com.dleonisa.dleonisa.back_end.controller;

import com.dleonisa.dleonisa.back_end.modelo.entity.Cliente;
import com.dleonisa.dleonisa.back_end.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/listar")
    public List<Cliente> listarClientes(){
        return clientService.listarClientes();
    }

    @PostMapping("/create")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){
        try {
            Cliente nuevo = clientService.nuevoCliente(cliente);
            return ResponseEntity.ok(nuevo);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

}
