package com.pangea.cita_api.config.mapper;

import com.pangea.cita_api.dto.request.ReservaRequestDTO;
import com.pangea.cita_api.dto.response.ReservaResponseDTO;
import com.pangea.cita_api.models.Horario;
import com.pangea.cita_api.models.Usuario;
import com.pangea.cita_api.models.Reserva;


public class ReservaMapper {

    public static ReservaResponseDTO toDTO(Reserva reserva) {
        return new ReservaResponseDTO(
                reserva.getReservaId(),
                reserva.getFechaReserva(),
                reserva.getConsulta(),
                reserva.getUsuario().getName(),
                reserva.getUsuario().getEmail(),
                reserva.getHorario().getHoraEstablecida()
        );
    }

    public static Reserva toEntity(ReservaRequestDTO dto, Long horarioId, Long usuarioId) {
        Reserva reserva = new Reserva();

        Horario horario = new Horario();
        horario.setHorarioId(horarioId);

        Usuario usuario = new Usuario();
        usuario.setUsuarioId(usuarioId);

        reserva.setConsulta(dto.getConsulta());
        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setHorario(horario);
        reserva.setUsuario(usuario);

        return reserva;
    }
}
