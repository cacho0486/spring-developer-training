package com.pfcti.spring_data.dto;
import com.pfcti.spring_data.model.Cliente;
import lombok.Data;

@Data
public class CuentaDTO {
    private int id;
    private String numero;
    private String tipo;
    private String estado;
}
