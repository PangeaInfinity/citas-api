package com.pangea.cita_api.dto.response;

import java.time.Instant;

public record ReservaResponseDTO(
    Long reservaId,
    Instant fechaReserva,
    String consulta,
    String name,
    String email,
    Instant horaEstablecida
) {
}
