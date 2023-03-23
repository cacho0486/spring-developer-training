package com.pfcti.spring_data.springbeans.dto;
import lombok.Data;

@Data
public class CuentaQueryDto {
    private int id;
    private String numero;
    private String tipo;
    private Boolean estado;
    private int idCliente;
}