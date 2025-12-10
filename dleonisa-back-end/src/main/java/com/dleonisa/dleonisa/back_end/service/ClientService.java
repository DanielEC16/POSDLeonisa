package com.dleonisa.dleonisa.back_end.service;

import com.dleonisa.dleonisa.back_end.modelo.dto.error.ErrorDTO;
import com.dleonisa.dleonisa.back_end.modelo.entity.Cliente;
import com.dleonisa.dleonisa.back_end.modelo.dto.client.ClientDTO;
import com.dleonisa.dleonisa.back_end.repository.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ICliente iCliente;
    @Autowired
    private ReniecApiService reniecApiService;

    //Listar Todos los Clientes Registrados
    public List<Cliente> listarClientes(){
        List<Cliente> clients = iCliente.findAll();
        return iCliente.findAll();
    }

    //Guardando un cliente
    public Cliente nuevoCliente(Cliente cliente){
        //Buscando si ya existe un cliente con ese DNI
        boolean existe = iCliente.findByDni(cliente.getDni()).isPresent();
        if(existe){
            throw new RuntimeException("El DNI ya esta registrado");
        }
        return iCliente.save(cliente);
    }

    public Cliente buscarCrearClientePorDni(String dni){
        Optional<Cliente> existe =
    }

    //Cambiando valores de un cliente registrado
    public Object updateCliente(ClientDTO clientDTO){
        if (clientDTO.dni()==null || clientDTO.dni().trim().isEmpty()){
            return new ErrorDTO("Inserte un DNI valido");
        }
        Optional<Cliente> clienteOriginal = iCliente.findById(clientDTO.id());
        if (clienteOriginal.isEmpty()) {
            return new ErrorDTO("El cliente que intenta editar no existe");
        }

        Optional<Cliente> clienteConMismoDni = iCliente.findByDni(clientDTO.dni());
        if (clienteConMismoDni.isPresent() &&
                !clienteConMismoDni.get().getId().equals(clientDTO.id())) {
            return new ErrorDTO("Ese DNI ya está siendo usado por otro cliente");
        }
        Cliente cliente = clienteOriginal.get();
        cliente.setNombre(clientDTO.nombre());
        cliente.setApellido(clientDTO.apellido());
        cliente.setDni(clientDTO.dni());
        iCliente.save(cliente);
        return new ErrorDTO("Cliente actualizado correctamente");
    }

}
