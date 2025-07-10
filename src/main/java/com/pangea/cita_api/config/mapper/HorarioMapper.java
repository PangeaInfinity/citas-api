package com.pangea.cita_api.config.mapper;

import com.pangea.cita_api.dto.request.HorarioRequestDTO;
import com.pangea.cita_api.dto.response.HorarioResponseDTO;
import com.pangea.cita_api.models.Horario;
import com.pangea.cita_api.models.Medico;

public class HorarioMapper {

    public static HorarioResponseDTO toDTO(Horario horario) {
        return new HorarioResponseDTO(
                horario.getHorarioId(),
                horario.getHoraEstablecida(),
                horario.getDisponible(),
                horario.getMedico() != null ? horario.getMedico().getMedicoId() : null
        );
    }

    public static Horario toEntity(HorarioRequestDTO dto) {
        Horario horario = new Horario();
        horario.setHoraEstablecida(dto.getHoraEstablecida());
        horario.setDisponible(dto.getDisponible());

        // Asociar médico si viene el ID
        if (dto.getMedicoId() != null) {
            Medico medico = new Medico();
            medico.setMedicoId(dto.getMedicoId());
            horario.setMedico(medico);
        }

        return horario;
    }
}
