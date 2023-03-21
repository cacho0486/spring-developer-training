package com.pfcti.spring_data.repository;
import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> , JpaSpecificationExecutor<Cliente> {
/*
    List<Cliente> findClientesByPais_NacimientoAndCuentas_EstadoIsTrue(String paisNacimiento);

    @Query(value = "select c from Cliente c where c.apellidos = :apellidos")
    List<Cliente> buscarPorApellidos(String apellidos);*/

}