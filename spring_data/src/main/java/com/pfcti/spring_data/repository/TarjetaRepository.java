package com.pfcti.spring_data.repository;

import com.pfcti.spring_data.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Integer> {

    void deleteAllByCliente_Id(int clientId);

    List<Tarjeta> findTarjetasByCliente_IdAndEstadoIsTrue(int clientId);
}
