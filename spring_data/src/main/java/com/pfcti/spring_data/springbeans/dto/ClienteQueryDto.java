package com.pfcti.spring_data.springbeans.dto;
import lombok.Data;

@Data
public class ClienteQueryDto {
    private String textoBusqueda;
    private ClienteQueryType tipoBusqueda;
}
