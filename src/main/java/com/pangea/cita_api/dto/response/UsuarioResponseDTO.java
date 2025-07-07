package com.pangea.cita_api.dto.response;

public record UsuarioResponseDTO(
        Long usuarioId,
        String name,
        String email
) {
}

