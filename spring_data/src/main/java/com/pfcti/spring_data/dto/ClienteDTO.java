package com.pfcti.spring_data.dto;
import com.pfcti.spring_data.model.Direccion;
import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    private int id;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String pais;
    private String pais_Nacimiento;
    private List<Direccion> DireccionsDto;
}
