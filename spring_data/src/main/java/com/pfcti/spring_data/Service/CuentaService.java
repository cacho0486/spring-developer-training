package com.pfcti.spring_data.Service;

import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.dto.CuentaDTO;
import com.pfcti.spring_data.model.Cliente;

import com.pfcti.spring_data.model.Cuenta;
import com.pfcti.spring_data.repository.CuentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CuentaService {
    private CuentaRepository cuentaRepository;

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
}

