package com.pfcti.spring_data.repository;

import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}