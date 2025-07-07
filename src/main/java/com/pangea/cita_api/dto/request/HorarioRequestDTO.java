package com.pangea.cita_api.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Data;

@Data
public class HorarioRequestDTO {

    @NotNull
    private Instant horaEstablecida;
}
