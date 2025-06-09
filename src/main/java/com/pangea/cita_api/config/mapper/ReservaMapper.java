package com.pangea.cita_api.config.mapper;

import com.pangea.cita_api.dto.response.ReservaResponseDTO;
import com.pangea.cita_api.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(source = "usuario.name", target = "name")
    @Mapping(source = "usuario.email", target = "email")
    @Mapping(source = "horario.horaEstablecida",target = "horaEstablecida")
    ReservaResponseDTO toDto(Reserva entity);
}
