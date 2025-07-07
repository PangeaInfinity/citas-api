package com.pangea.cita_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicoResponseDTO {
    //attributes

    private Long medicoId;
    private String nombre;
    private String especialidad;
}//end class
