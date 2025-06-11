package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.Clients;
import com.dleonisa.dleonisa.back_end.modelo.dto.ClientDTO;
import com.dleonisa.dleonisa.back_end.repository.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ICliente iCliente;

    //Listar Todos los Clientes Registrados
    public List<ClientDTO> listarClientes(){
        List<Clients> clients = iCliente.findAll();
        return clients.stream()
                .map(client -> new ClientDTO(
                        client.getNombre(),
                        client.getApellido(),
                        client.getDni()
                )).toList();
    }


}
