package com.pangea.cita_api.config.mapper;

import com.pangea.cita_api.dto.request.ReservaRequestDTO;
import com.pangea.cita_api.dto.response.ReservaResponseDTO;
import com.pangea.cita_api.models.Reserva;
import com.pangea.cita_api.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/*
@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(source = "usuario.name", target = "name")
    @Mapping(source = "usuario.email", target = "email")
    @Mapping(source = "horario.horaEstablecida", target = "horaEstablecida")
    ReservaResponseDTO toDto(Reserva entity);

    @Mapping(source = "usuarioId", target = "usuario.usuarioId")
    @Mapping(source = "horarioId", target = "horario.horarioId")
    Reserva toEntity(ReservaRequestDTO dto);
}*/

public class ReservaMapper {

    public static ReservaResponseDTO toDTO(Reserva reserva){
        return new ReservaResponseDTO(reserva.getReservaId(),
                reserva.getFechaReserva(),
                reserva.getConsulta(),
                reserva.getUsuario().getName(),
                reserva.getUsuario().getEmail(),
                reserva.getHorario().getHoraEstablecida());
    }

    public static Reserva toEnity(ReservaRequestDTO dto,Long horarioId, Long usuarioId){
        Reserva reserva = new Reserva();
        reserva.setConsulta(dto.getConsulta());
        reserva.setFechaReserva(dto.getFechaReserva());
        return reserva;
    }
}