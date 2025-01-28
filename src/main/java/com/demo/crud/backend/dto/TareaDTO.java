package com.demo.crud.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TareaDTO {
    @NotBlank(message = "El título es obligatorio")
    private String titulo;
    private String descripcion;
    private boolean completada;
}
