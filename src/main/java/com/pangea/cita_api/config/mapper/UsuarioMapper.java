package com.pangea.cita_api.config.mapper;

import com.pangea.cita_api.dto.request.UsuarioRequestDTO;
import com.pangea.cita_api.dto.response.UsuarioResponseDTO;
import com.pangea.cita_api.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioResponseDTO toDto(Usuario entity);

    Usuario toEntity(UsuarioRequestDTO requestDTO);
}
