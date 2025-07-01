package com.dleonisa.dleonisa.back_end.controller;

import com.dleonisa.dleonisa.back_end.modelo.dto.ClientDTO;
import com.dleonisa.dleonisa.back_end.modelo.dto.error.ErrorDTO;
import com.dleonisa.dleonisa.back_end.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<?> crearCliente(@RequestBody ClientDTO clientDTO){
        Object result = clientService.createClient(clientDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update")
    public ResponseEntity<?> actualizarCliente(@RequestBody ClientDTO clientDTO){
        Object result = clientService.updateCliente(clientDTO);
        return ResponseEntity.ok(result);
    }


}
