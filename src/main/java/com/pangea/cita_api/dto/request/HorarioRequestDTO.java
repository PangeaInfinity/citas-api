package com.pangea.cita_api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class HorarioRequestDTO {

    @NotNull
    private Instant horaEstablecida;

    @NotNull
    private Boolean disponible;

    @NotNull
    private Long medicoId;
}
