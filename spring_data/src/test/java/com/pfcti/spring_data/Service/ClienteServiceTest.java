package com.pfcti.spring_data.Service;

import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
@Slf4j
class ClienteServiceTest {
    @Autowired
    private ClienteService clienteService;
    @PersistenceContext
    private EntityManager entityManager;
    @Test
    void insertarCliente() {
        List<Cliente> clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        System.out.println("listar antes de insertar: " + clienteList);
        System.out.println("Cantidad de la lista: " + clienteList.size());
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setApellidos("Acevedo");
        clienteDTO.setNombre("Max");
        clienteDTO.setCedula("112970420");
        clienteDTO.setTelefono("71082859");

        clienteService.insertaCliente(clienteDTO);

        clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        System.out.println("listar despues de insertar: " + clienteList);
        System.out.println("Cantidad de la lista: " + clienteList.size());
        System.out.println("Apellidos: " + clienteList.get(clienteList.size()-1).getApellidos());
        System.out.println("Nombre: " + clienteList.get(clienteList.size()-1).getNombre());
        System.out.println("Telefono: " + clienteList.get(clienteList.size()-1).getTelefono());
        System.out.println("Cedula: " + clienteList.get(clienteList.size()-1).getCedula());
        assertFalse(clienteList.isEmpty());
        assertEquals("112970420", clienteList.get(5).getCedula());
    }

   @Test
    void obtenerCliente(){
        ClienteDTO clienteDTO = clienteService.obtenerCliente(3);
        System.out.println("Apellidos: " + clienteDTO.getApellidos());
        System.out.println("Nombre: " + clienteDTO.getNombre());
        System.out.println("Telefono: " + clienteDTO.getTelefono());
        System.out.println("Cedula: " + clienteDTO.getCedula());
    }

    @Test
    void eliminarCliente(){
        ClienteDTO clienteDTO = clienteService.obtenerCliente(2);
        System.out.println("Apellidos: " + clienteDTO.getApellidos());
        System.out.println("Nombre: " + clienteDTO.getNombre());
        System.out.println("Telefono: " + clienteDTO.getTelefono());
        System.out.println("Cedula: " + clienteDTO.getCedula());
        clienteService.eliminarCliente(2);
        clienteDTO = clienteService.obtenerCliente(2);
    }

    @Test
    void actualizarCliente(){
        ClienteDTO clienteDtoBase = clienteService.obtenerCliente(1);
        System.out.println(clienteDtoBase);

        clienteDtoBase.setNombre(clienteDtoBase.getNombre() + "TEST");
        clienteDtoBase.setCedula(clienteDtoBase.getCedula() + "TEST");
        clienteDtoBase.setTelefono(clienteDtoBase.getTelefono() + "TEST");
        clienteDtoBase.setApellidos(clienteDtoBase.getApellidos() + "TEST");
        clienteService.actualizarCliente(clienteDtoBase);

        ClienteDTO clienteDtoBaseUpdated = clienteService.obtenerCliente(1);

        System.out.println(clienteDtoBaseUpdated);
        assertEquals("ROBERTOTEST", clienteDtoBaseUpdated.getNombre());
        assertEquals("PEREZTEST", clienteDtoBaseUpdated.getApellidos());
    }
}