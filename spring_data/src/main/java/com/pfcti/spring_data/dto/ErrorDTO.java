package com.pfcti.spring_data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private Integer status;
    private int codigo;
    private String message;

    public ErrorDTO(Integer status, String message){
        this.status=status;
        this.message=message;
    }
}
