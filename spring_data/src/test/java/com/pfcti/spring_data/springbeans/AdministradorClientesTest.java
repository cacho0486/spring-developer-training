package com.pfcti.spring_data.springbeans;
import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.repository.ClienteRepository;
import com.pfcti.spring_data.service.ClienteService;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryDto;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdministradorClientesTest {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        this.setupClientes();
    }

    private void setupClientes() {
        List<ClienteDTO> clienteDtos = List.of(
                new ClienteDTO(1, "Alberto", "Salazar", "1890000000", "0999714563", "CR", null, null, null, null),
                new ClienteDTO(2, "Rosa", "Salazar", "1890000001", "0983475616", "CR", null, null, null, null),
                new ClienteDTO(3, "Alexis", "Vivanco", "1890000002", "0983475616", "CR", null, null, null, null),
                new ClienteDTO(4, "Natalie", "Vivanco", "1890000003", "0983665616", "CR", null, null, null, null),
                new ClienteDTO(5, "Ximena", "Silva", "1890000004", "0983475616", "CR", null, null, null, null),
                new ClienteDTO(6, "Thalia", "Rodriguez", "1890000005", "0983475616", "CR", null, null, null, null),
                new ClienteDTO(7, "Jonh", "Rodriguez", "1890000006", "0983475616", "CR", null, null, null, null),
                new ClienteDTO(8, "Eduardo", "Guerra", "1890000007", "0983475616", "CR", null, null, null, null),
                new ClienteDTO(9, "Juan", "Vaca", "1890000008", "0983475616", "CR", null, null, null, null),
                new ClienteDTO(10, "Cristina", "Ortiz", "1890000009", "0983475616", "CR", null, null, null, null)
        );
        clienteDtos.forEach(clienteDto -> this.clienteService.insertarCliente(clienteDto));
    }
    @Test
    void obtenerListaClientesPorCriterio() {
        //Se instancia la clase, se pasa los elementos dependientes al constructor
        AdministradorClientes administradorClientes = new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
        administradorClientes.setClienteRepository(clienteRepository);
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTipoBusqueda(ClienteQueryType.CEDULA);
        clienteQueryDto.setTextoBusqueda("1890000002");
        //Se invoca al método respectivo
        List<ClienteDTO> clienteDtos = administradorClientes.obtenerListaClientesPorCriterio(clienteQueryDto);
        clienteDtos.forEach(clienteDtosResultado -> {System.out.println("clienteDtos es:"+ clienteDtosResultado);});
        assertEquals(1, clienteDtos.size());
    }
}