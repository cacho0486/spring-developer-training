package com.pfcti.spring_data.repository;

import com.pfcti.spring_data.model.Direccion;
import com.pfcti.spring_data.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InversionRepository extends JpaRepository<Inversion, Integer> {
}

