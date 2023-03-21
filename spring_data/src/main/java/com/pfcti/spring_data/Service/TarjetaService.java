package com.pfcti.spring_data.Service;

import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.dto.TarjetaDTO;
import com.pfcti.spring_data.model.Cliente;
import com.pfcti.spring_data.model.Tarjeta;
import com.pfcti.spring_data.repository.TarjetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor


public class TarjetaService {
    private TarjetaRepository TarjetaRepository;

    public void actualizarEstadoTarjeta(TarjetaDTO tarjetaDto){
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setEstado(tarjetaDto.getEstado());
        TarjetaRepository.save(tarjeta);
    }
}