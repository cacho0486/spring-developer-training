package com.pfcti.spring_data.springbeans;

import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.repository.ClienteRepository;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryDto;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdministradorClientes {
    private ClienteRepository clienteRepository;

    private ClienteQueryType defaultClienteQueryType;
    public AdministradorClientes(ClienteRepository clienteRepository, ClienteQueryType defaultClienteQueryType) {
        this.clienteRepository = clienteRepository;
        this.defaultClienteQueryType = defaultClienteQueryType;
    }

    public List<ClienteDTO> obtenerListaClientesPorCriterio(ClienteQueryDto clienteQueryDto) {
        List<Cliente> clientes = null;
        if (clienteQueryDto.getTipoBusqueda() == null) {
            clienteQueryDto.setTipoBusqueda(defaultClienteQueryType);
        }
        if (ClienteQueryType.CEDULA.equals(clienteQueryDto.getTipoBusqueda())) {
            clientes = this.clienteRepository.findByCedula(clienteQueryDto.getTextoBusqueda());
        } else if (ClienteQueryType.NOMBRES.equals(clienteQueryDto.getTipoBusqueda())) {
            clientes = this.clienteRepository.findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(clienteQueryDto.getTextoBusqueda(), clienteQueryDto.getTextoBusqueda());
        }
        return Optional.ofNullable(clientes).map(clientesAux-> clientesAux.stream().map(cliente -> {
            ClienteDTO clienteDto = new ClienteDTO();
            clienteDto.setNombre(cliente.getNombre());
            clienteDto.setApellidos(cliente.getApellidos());
            clienteDto.setCedula(cliente.getCedula());
            clienteDto.setTelefono(cliente.getTelefono());
            return clienteDto;
        }).collect(Collectors.toList())).orElse(new ArrayList<>());
    }
}