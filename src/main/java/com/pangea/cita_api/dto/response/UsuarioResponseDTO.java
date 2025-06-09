package com.pangea.cita_api.dto.response;

public record UsuarioResponseDTO(
        String email,
        String password,
        String name
) {
}
