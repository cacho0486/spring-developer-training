package com.pfcti.spring_data.springbeans.business.impl;

import com.pfcti.spring_data.Service.CuentaService;
import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.springbeans.business.BuscadorCuentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicioCuentasBdd")
public class BuscadorCuentasBdd implements BuscadorCuentas {

    @Autowired
    private CuentaService cuentaService;

    @Override
    public List<CuentaDTO> buscarCuentasPorCliente(int idCliente) {
        return cuentaService.buscarCuentasPorCliente(idCliente);
    }
}
