package com.pfcti.spring_data.Service;
import com.pfcti.spring_data.criteria.CuentaSpecification;
import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.model.Cuenta;
import com.pfcti.spring_data.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;

    public List<CuentaDTO> buscarCuentasDinamicamentePorCriterio(CuentaDTO cuentaDtoFilter){
        return cuentaRepository.findAll(cuentaSpecification.buildFilter(cuentaDtoFilter))
                .stream().map(this::fromCuentaToDto).collect(Collectors.toList());
    }

    private CuentaDTO fromCuentaToDto(Cuenta cuenta){
        CuentaDTO cuentaDTO = new CuentaDTO();
        BeanUtils.copyProperties(cuenta, cuentaDTO);
        return cuentaDTO;
    }
}