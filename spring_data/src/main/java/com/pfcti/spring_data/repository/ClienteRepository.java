package com.pfcti.spring_data.repository;

import com.pfcti.spring_data.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}