package com.pfcti.spring_data.repository;

import com.pfcti.spring_data.model.Cuenta;
import com.pfcti.spring_data.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
}