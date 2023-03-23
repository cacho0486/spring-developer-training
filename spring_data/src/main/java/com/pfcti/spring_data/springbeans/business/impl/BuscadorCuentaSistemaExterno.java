package com.pfcti.spring_data.springbeans.business.impl;

import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.springbeans.business.BuscadorClientes;
import com.pfcti.spring_data.springbeans.business.BuscadorCuentas;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryDto;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryType;
import com.pfcti.spring_data.springbeans.dto.CuentaQueryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicioCuentasExterno")
public class BuscadorCuentaSistemaExterno implements BuscadorCuentas {

    @Override
    public List<CuentaDTO> buscarCuentasPorCliente(int idCliente) {
        CuentaDTO cuentaDto = new CuentaDTO();
        cuentaDto.setClient_id(1);
        cuentaDto.setId(1);
        cuentaDto.setEstado(true);
        cuentaDto.setNumero("123123213231212");
        cuentaDto.setTipo("VISA");
        return List.of(cuentaDto);
    }
}

