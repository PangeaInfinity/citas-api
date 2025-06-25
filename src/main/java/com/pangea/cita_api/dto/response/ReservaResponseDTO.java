package com.pangea.cita_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ReservaResponseDTO{
    private Long reservaId;
    private Instant fechaReserva;
    private String consulta;
    private String name;
    private String email;
    private Instant horaEstablecida;
}
