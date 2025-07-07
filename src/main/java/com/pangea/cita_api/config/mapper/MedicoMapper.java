package com.pangea.cita_api.config.mapper;

import com.pangea.cita_api.dto.request.MedicoRequestDTO;
import com.pangea.cita_api.dto.response.MedicoResponseDTO;
import com.pangea.cita_api.models.Medico;

public class MedicoMapper {

    //METHOD
    public static MedicoResponseDTO toDTO(Medico medico) {
        return new MedicoResponseDTO(
                medico.getMedicoId(),
                medico.getNombre(),
                medico.getEspecialidad()
        );
    }

    public static Medico toEntity(MedicoRequestDTO dto) {
        Medico medico = new Medico();
        medico.setNombre(dto.getNombre());
        medico.setEspecialidad(dto.getEspecialidad());
        return medico;
    }//end method

}//end class
