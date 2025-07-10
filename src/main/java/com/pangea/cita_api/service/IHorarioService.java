package com.pangea.cita_api.service;

import com.pangea.cita_api.models.Horario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHorarioService extends ICRUDService<Horario, Long> {

    // Método para obtener horarios disponibles paginados de un médico
    Page<Horario> obtenerHorariosDisponiblesPorMedico(Long medicoId, Pageable pageable);

}
