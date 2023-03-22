package com.pfcti.spring_data.Service;
import com.pfcti.spring_data.dto.ClienteDTO;
import com.pfcti.spring_data.dto.TarjetaDTO;
import com.pfcti.spring_data.model.Tarjeta;
import com.pfcti.spring_data.repository.TarjetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TarjetaService {
    private TarjetaRepository tarjetaRepository;

    public TarjetaDTO cambiarEstadoTarjeta(int id, Boolean estado){
        TarjetaDTO tarjetaDTO = new TarjetaDTO();
        Tarjeta tarjeta = tarjetaRepository.findById(id).orElseThrow(() -> {throw new RuntimeException("Tarjeta no existe");});
        tarjetaDTO.setEstado(estado);
        tarjetaDTO.setId(tarjeta.getId());
        tarjetaDTO.setTipo(tarjeta.getTipo());
        tarjetaDTO.setNumero(tarjeta.getNumero());
        tarjeta.setEstado(estado);
        tarjetaRepository.save(tarjeta);
        return tarjetaDTO;
    }
}
