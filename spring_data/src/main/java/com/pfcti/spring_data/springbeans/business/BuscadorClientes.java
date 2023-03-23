package com.pfcti.spring_data.springbeans.business;

import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryDto;

import java.util.List;

public interface BuscadorClientes {
    List<ClienteDTO> obtenerListaClientes(ClienteQueryDto clienteQueryDto);
}

