package com.pangea.cita_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class ReservaRequestDTO {
    @NotBlank
    private Long usuarioId;

    @NotBlank
    private Long horarioId;

    @NotBlank
    private String consulta;

    @NotBlank
    private Instant fechaReserva;
}
