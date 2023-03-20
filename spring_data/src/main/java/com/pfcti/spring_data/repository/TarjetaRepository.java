package com.pfcti.spring_data.repository;

import com.pfcti.spring_data.model.Inversion;
import com.pfcti.spring_data.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaRepository  extends JpaRepository<Tarjeta, Integer> {
}
