package com.pfcti.spring_data.springwebservices.api;

import com.pfcti.spring_data.service.ClienteService;
import com.pfcti.spring_data.dto.ClienteDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cliente")
@Slf4j
public class ClienteApi {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ClienteDTO buscarCliente(@PathVariable int id) {
        log.info("Busqueda de cliente: {}", id);
        return clienteService.obtenerCliente(id);
    }


    @GetMapping(value = "/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ClienteDTO buscarClienteXML(@PathVariable int id) {
        log.info("Busqueda de cliente: {}", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "xml/json/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ClienteDTO buscarClienteXMLJson(@PathVariable int id) {
        log.info("Busqueda de cliente: {}", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "parameter", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ClienteDTO buscarClienteParametro(@RequestParam int id) {
        log.info("Busqueda de cliente: {}", id);
        return clienteService.obtenerCliente(id);
    }

    @PostMapping
    public void guardarCliente(@Valid @RequestBody ClienteDTO clienteDto) {
        log.info("cliente a crear :{}", clienteDto);
        clienteService.insertarCliente(clienteDto);
    }

    @GetMapping(value="/all")
    public List<ClienteDTO> buscarTodosCliente(){
        return clienteService.listarTodosLosClientes();
    }

    @PutMapping
    public void actualizarCliente(ClienteDTO clienteDto){
        log.info("actualizar cliente :{}", clienteDto);
        clienteService.actualizarCliente(clienteDto);
    }

    @DeleteMapping(value="/{id}")
    public void actualizarCliente(@PathVariable int id){
        log.info("Borrar cliente :{}", id);
        clienteService.eliminarCliente(id);
    }
}