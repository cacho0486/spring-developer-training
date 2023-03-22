package com.pfcti.spring_data.repository;

import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.model.Cuenta;
import com.pfcti.spring_data.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Integer>, JpaSpecificationExecutor<Cuenta> {

    void deleteAllByCliente_Id(int clientId);

    List<Cuenta> findCuentasByCliente_IdAndEstadoIsTrue(int clientId);
}
