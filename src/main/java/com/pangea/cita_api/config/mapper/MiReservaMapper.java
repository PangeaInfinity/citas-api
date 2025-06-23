package com.pangea.cita_api.config.mapper;

import com.pangea.cita_api.dto.request.MiReservaRequestDTO;
import com.pangea.cita_api.dto.response.MiReservaResponseDTO;
import com.pangea.cita_api.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MiReservaMapper {

    @Mapping(source = "usuario.usuarioId", target = "usuarioId")
    @Mapping(source = "usuario.name", target = "usuarioNombre")
    MiReservaResponseDTO toDto(MiReserva entity);

    @Mapping(source = "usuarioId", target = "usuario", qualifiedByName = "usuarioFromId")
    MiReserva toEntity(MiReservaRequestDTO dto);

    @Named("usuarioFromId")
    default Usuario usuarioFromId(Long usuarioId) {
        if (usuarioId == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(usuarioId);
        return usuario;
    }
}

