package com.pfcti.spring_data.dto;
import com.pfcti.spring_data.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {
    private int id;
    private String numero;
    private String tipo;
    private Boolean estado; //activo o inactivo

    private int client_id;
}
