package com.pangea.cita_api.config.mapper;

import com.pangea.cita_api.dto.request.ReservaRequestDTO;
import com.pangea.cita_api.dto.response.ReservaResponseDTO;
import com.pangea.cita_api.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(source = "reservaId", target = "reservaId")
    @Mapping(source = "fechaReserva", target = "fechaReserva")
    @Mapping(source = "consulta", target = "consulta")
    @Mapping(source = "usuario.name", target = "name")
    @Mapping(source = "usuario.email", target = "email")
    @Mapping(source = "horario.horaEstablecida", target = "horaEstablecida")
    ReservaResponseDTO toDto(Reserva entity);

    @Mapping(source = "usuarioId", target = "usuario.usuarioId")
    @Mapping(source = "horarioId", target = "horario.horarioId")
    Reserva toEntity(ReservaRequestDTO dto);
}