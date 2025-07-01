package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.dto.error.ErrorDTO;
import com.dleonisa.dleonisa.back_end.modelo.entity.Clients;
import com.dleonisa.dleonisa.back_end.modelo.dto.ClientDTO;
import com.dleonisa.dleonisa.back_end.repository.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ICliente iCliente;

    //Listar Todos los Clientes Registrados
    public List<ClientDTO> listarClientes(){
        List<Clients> clients = iCliente.findAll();
        return clients.stream()
                .map(client -> new ClientDTO(
                        null,
                        client.getNombre(),
                        client.getApellido(),
                        client.getDni()
                )).toList();
    }

    //Guardando un cliente
    public Object createClient(ClientDTO clientDTO){
        if(iCliente.existsByDni(clientDTO.dni())){
            return new ErrorDTO("El cliente con este DNI ya existe");
        }
        Clients clienteNuevo = Clients.builder()
                .nombre(clientDTO.nombre())
                .apellido(clientDTO.apellido())
                .dni(clientDTO.dni())
                .build();
        Clients clientSaved = iCliente.save(clienteNuevo);
        return new ErrorDTO("Creado correctamente");
    }

    //Cambiando valores de un cliente registrado
    public Object updateCliente(ClientDTO clientDTO){
        if (clientDTO.dni()==null || clientDTO.dni().trim().isEmpty()){
            return new ErrorDTO("Inserte un DNI valido");
        }
        Optional<Clients> clienteOriginal = iCliente.findById(clientDTO.id());
        if (clienteOriginal.isEmpty()) {
            return new ErrorDTO("El cliente que intenta editar no existe");
        }

        Optional<Clients> clienteConMismoDni = iCliente.findByDni(clientDTO.dni());
        if (clienteConMismoDni.isPresent() &&
                !clienteConMismoDni.get().getId().equals(clientDTO.id())) {
            return new ErrorDTO("Ese DNI ya está siendo usado por otro cliente");
        }
        Clients cliente = clienteOriginal.get();
        cliente.setNombre(clientDTO.nombre());
        cliente.setApellido(clientDTO.apellido());
        cliente.setDni(clientDTO.dni());
        iCliente.save(cliente);
        return new ErrorDTO("Cliente actualizado correctamente");
    }

}
