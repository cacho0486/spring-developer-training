package com.pfcti.spring_data.Service;

import com.pfcti.spring_data.criteria.CuentaSpecification;
import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.model.Cliente;

import com.pfcti.spring_data.model.Cuenta;
import com.pfcti.spring_data.repository.CuentaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;

    /*public List<CuentaDTO> obtenerCuentasPorEstadoCliente(List<ClienteDTO> lista){
        List<Cuenta> cuentas = cuentaRepository.findAll();
        List<CuentaDTO> cuentasDTO = null;
        ClienteDTO clienteDTO = new ClienteDTO();
        for(Cuenta cuenta :cuentas) {
            if (Cliente.getPais().compareTo(pais)==0){
                clienteDTO.setId(Cliente.getId());
                clienteDTO.setApellidos(Cliente.getApellidos());
                clienteDTO.setNombre(Cliente.getNombre());
                clienteDTO.setTelefono(Cliente.getTelefono());
                clienteDTO.setCedula(Cliente.getCedula());
                clienteDTO.add(clienteDTO);
            }
        }
        return cuentasDTO;
    }*/

    private CuentaDTO fromCuentaToDto(Cuenta cuenta){
        CuentaDTO cuentaDto = new CuentaDTO();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }

    public List<CuentaDTO> buscarCuentasDinamicamentePorCriterio(CuentaDTO cuentaDtoFilter){
        return cuentaRepository.findAll(cuentaSpecification.buildFilter(cuentaDtoFilter))
                .stream().map(this::fromCuentaToDto).collect(Collectors.toList());
    }


}

