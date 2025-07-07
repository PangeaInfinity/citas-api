package com.pangea.cita_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicoRequestDTO {
    //attributes
    @NotBlank
    private String nombre;

    @NotBlank
    private String especialidad;
}
