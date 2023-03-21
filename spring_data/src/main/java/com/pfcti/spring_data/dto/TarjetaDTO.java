package com.pfcti.spring_data.dto;
import lombok.Data;

@Data
public class TarjetaDTO {
    private int id;
    private String numero;
    private String tipo;
    private Boolean estado;
}
