package com.pangea.cita_api.config.mapper;

import com.pangea.cita_api.dto.request.UsuarioRequestDTO;
import com.pangea.cita_api.dto.response.UsuarioResponseDTO;
import com.pangea.cita_api.models.Usuario;

public class UsuarioMapper {

    public static UsuarioResponseDTO toDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getUsuarioId(),
                usuario.getName(),
                usuario.getEmail()
        );
    }

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setName(dto.getName());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword()); // Se puede encriptar aquí si tenés BCrypt configurado
        return usuario;
    }
}
