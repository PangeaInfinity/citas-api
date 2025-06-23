package com.pangea.cita_api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MiReservaRequestDTO {

    private LocalDate fechaReserva;
    private String horario;
    private Long usuarioId;
}

