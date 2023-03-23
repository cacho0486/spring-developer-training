package com.pfcti.spring_data.springbeans.business;

import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryDto;
import com.pfcti.spring_data.springbeans.dto.CuentaQueryDto;

import java.util.List;

public interface BuscadorCuentas {
    List<CuentaDTO> buscarCuentasPorCliente(int idCliente);
}

