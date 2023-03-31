package com.pfcti.spring_data.service;

import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.model.Cuenta;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class CuentaServiceTest {
    @Autowired
    private CuentaService cuentaService;
    @Test
    void buscarCuentasDinamicamentePorCriterio() {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setNumero("33333");
        List<CuentaDTO> resultadoCriteriosConDatosDTO = cuentaService.buscarCuentasDinamicamentePorCriterio(cuentaDTO);
        resultadoCriteriosConDatosDTO.forEach(cuentaDTOResultado -> {System.out.println("CuentaDTO es:"+ cuentaDTOResultado);});
        assertEquals(1,resultadoCriteriosConDatosDTO.size());
    }

    @Test
    void insertarCuenta() {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setNumero("65665656");
        cuentaDTO.setTipo("1");
        cuentaDTO.setEstado(true);
        cuentaService.insertarCuenta(cuentaDTO);
        assertEquals(1,1);
    }
}
