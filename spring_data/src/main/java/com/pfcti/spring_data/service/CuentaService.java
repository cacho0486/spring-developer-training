package com.pfcti.spring_data.service;
import com.pfcti.spring_data.criteria.CuentaSpecification;
import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.model.Cuenta;
import com.pfcti.spring_data.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;

    public List<CuentaDTO> buscarCuentasDinamicamentePorCriterio(CuentaDTO cuentaDtoFilter){
        return cuentaRepository.findAll(cuentaSpecification.buildFilter(cuentaDtoFilter))
                .stream().map(this::fromCuentaToDto).collect(Collectors.toList());
    }

     public List<CuentaDTO> buscarCuentasPorCliente(int idCliente) {
        List<CuentaDTO> cuentasPorCliente = new ArrayList<>();
        cuentaRepository.findCuentasByCliente_IdAndEstadoIsTrue(idCliente)
                .stream()
                .map(cuenta -> {
                    cuentasPorCliente.add(fromCuentaToDto(cuenta));
                  //  log.info("Cuenta de Cliente :{}", cuenta);
                    return cuenta;}
                ).collect(Collectors.toList());
        return cuentasPorCliente;
    }

    private CuentaDTO fromCuentaToDto(Cuenta cuenta) {
        CuentaDTO cuentaDto = new CuentaDTO();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }
}