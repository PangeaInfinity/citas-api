package com.pangea.cita_api.dto.response;

import java.time.Instant;

public record HorarioResponseDTO(
        Long horarioId,
        Instant horaEstablecida
) {
}
