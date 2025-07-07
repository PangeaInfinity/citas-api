package com.pangea.cita_api.config.mapper;

import com.pangea.cita_api.dto.request.HorarioRequestDTO;
import com.pangea.cita_api.dto.response.HorarioResponseDTO;
import com.pangea.cita_api.models.Horario;

public class HorarioMapper {

    public static HorarioResponseDTO toDTO(Horario horario) {
        return new HorarioResponseDTO(
                horario.getHorarioId(),
                horario.getHoraEstablecida()
        );
    }

    public static Horario toEntity(HorarioRequestDTO dto) {
        Horario horario = new Horario();
        horario.setHoraEstablecida(dto.getHoraEstablecida());
        return horario;
    }
}
