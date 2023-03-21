package com.pfcti.spring_data.Service;

import com.pfcti.spring_data.criteria.ClienteSpecification;
import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ClienteService {
   ClienteRepository clienteRepository;

private ClienteSpecification clienteSpecification;

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
/*
    public List<ClienteDTO> obtenerClientesPorCodigoISOPaisYCuentasActivas(String codigoISOPais){
        List<ClienteDTO> resultadoClientesDto = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findClientesByPais_NacimientoAndCuentas_EstadoIsTrue(codigoISOPais);
        clientes.forEach(cliente -> {
            ClienteDTO clienteDto = new ClienteDTO();
            clienteDto.setId(cliente.getId());
            clienteDto.setApellidos(cliente.getApellidos());
            clienteDto.setNombre(cliente.getNombre());
            clienteDto.setCedula(cliente.getCedula());
            clienteDto.setPaisNacimiento(cliente.getPais_Nacimiento());
            resultadoClientesDto.add(clienteDto);
            System.out.println(clienteDto);
        });
        return resultadoClientesDto;
    }

/*
    public List<Cliente> buscarClientesPorApellido(String apellidos){
        return clienteRepository.buscarPorApellidos(apellidos);
    }
    */

    public List<ClienteDTO> buscarClientesDinamicamentePorCriterio(ClienteDTO clienteDtoFilter){
        return clienteRepository.findAll(clienteSpecification.buildFilter(clienteDtoFilter))
                .stream().map(this::fromClienteToDto).collect(Collectors.toList());
    }

    private ClienteDTO fromClienteToDto(Cliente cliente){
        ClienteDTO clienteDto = new ClienteDTO();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }


}
