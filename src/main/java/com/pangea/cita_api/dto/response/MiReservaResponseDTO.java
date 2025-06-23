package com.pangea.cita_api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MiReservaResponseDTO {

    private Long reservaId;
    private LocalDate fechaReserva;
    private String horario;
    private Long usuarioId;
    private String usuarioNombre;
}

