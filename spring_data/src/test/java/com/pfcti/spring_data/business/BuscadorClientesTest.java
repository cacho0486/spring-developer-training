package com.pfcti.spring_data.business;
import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.springbeans.business.BuscadorClientes;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryDto;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BuscadorClientesTest {

    @Autowired
    private BuscadorClientes baseDeDatos;

    @Autowired
    @Qualifier("sistemaExterno")
    private BuscadorClientes buscadorClientes;

    @Test
    void obtenerListaClientesDeBaseDeDatos() {
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("1111");
        clienteQueryDto.setTipoBusqueda(ClienteQueryType.CEDULA);
        List<ClienteDTO> resultadoClienteDtos = baseDeDatos.obtenerListaClientes(clienteQueryDto);
        resultadoClienteDtos.forEach(clienteDto ->
                {
                    System.out.println("Resultado de la busqueda" + clienteDto.getNombre() + clienteDto.getApellidos());
                }
        );
        Assertions.assertEquals(1, resultadoClienteDtos.size());
    }

    @Test
    void obtenerListaClientesDeSistemaExterno() {
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("1890000000");
        clienteQueryDto.setTipoBusqueda(ClienteQueryType.CEDULA);
        List<ClienteDTO> resultadoClienteDtos = buscadorClientes.obtenerListaClientes(clienteQueryDto);
        resultadoClienteDtos.forEach(clienteDto ->
                {
                    System.out.println("Resultado de la busqueda" + clienteDto.getNombre() + clienteDto.getApellidos());
                }
        );
        Assertions.assertEquals(1, resultadoClienteDtos.size());
    }
}
