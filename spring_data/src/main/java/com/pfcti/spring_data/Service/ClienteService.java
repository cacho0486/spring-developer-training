package com.pfcti.spring_data.Service;

import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {
   ClienteRepository clienteRepository;

    public void insertaCliente(ClienteDTO clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);

    }

    public ClienteDTO obtenerCliente (int idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(
                        () -> {throw new RuntimeException("Cliente no existe");});

        ClienteDTO clienteDto = new ClienteDTO();
        clienteDto.setId(cliente.getId());
        clienteDto.setApellidos(cliente.getApellidos());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setCedula(cliente.getCedula());

        return clienteDto;
    }

    public void actualizarCliente(ClienteDTO clienteDto){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidos(clienteDto.getApellidos ());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

    public void eliminarCliente(Integer clienteId){
        clienteRepository.deleteById(clienteId);
    }
}
