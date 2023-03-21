package com.pfcti.spring_data.repository;

import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>, JpaSpecificationExecutor<Cuenta> {

    public List<CuentaDTO> uscarCuentasDinamicamentePorCriterio(CuentaDTO cuentaDtoFilter);
void deleteAllByCliente_Id(int Cliente_Id);
}