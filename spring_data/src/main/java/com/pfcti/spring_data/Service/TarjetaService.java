package com.pfcti.spring_data.Service;

import com.pfcti.spring_data.repository.TarjetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TarjetaService {
    private TarjetaRepository TarjetaRepository;
}