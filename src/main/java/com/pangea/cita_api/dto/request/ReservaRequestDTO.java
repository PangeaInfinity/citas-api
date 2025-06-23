package com.pangea.cita_api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class ReservaRequestDTO {
    @NotNull
    private Long usuarioId;

    @NotNull
    private Long horarioId;

    @NotNull
    private String consulta;

    @NotNull
    private Instant fechaReserva;
}
