package com.pfcti.spring_data.business;
import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.springbeans.business.BuscadorClientes;
import com.pfcti.spring_data.springbeans.business.BuscadorCuentas;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryDto;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryType;
import com.pfcti.spring_data.springbeans.dto.CuentaQueryDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class BuscadorCuentasTest {

    @Autowired
    BuscadorCuentas servicioCuentasBdd;

    @Autowired
    BuscadorCuentas servicioCuentasExterno;

    @Test
    void buscarCuentasPorClienteBdd() {
        List<CuentaDTO> resultado = servicioCuentasBdd.buscarCuentasPorCliente(1);
        resultado.forEach(cuentaDto -> System.out.println("Cuenta de cliente: "+ cuentaDto));
        Assertions.assertEquals(2, resultado.size());
    }

    @Test
    void buscarCuentasPorClienteSistemaExterno() {
        List<CuentaDTO> resultado = servicioCuentasExterno.buscarCuentasPorCliente(1);
        resultado.forEach(cuentaDto -> System.out.println("Cuenta de cliente: "+ cuentaDto));
        Assertions.assertEquals(1, resultado.size());
    }
}