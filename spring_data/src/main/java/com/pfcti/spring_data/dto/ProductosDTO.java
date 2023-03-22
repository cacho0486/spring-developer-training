package com.pfcti.spring_data.dto;
import lombok.Data;

import java.util.List;

@Data
public class ProductosDTO {
    private List<CuentaDTO> cuentas;
    private List<TarjetaDTO> tarjetas;
    private List<InversionDTO> inversiones;
}