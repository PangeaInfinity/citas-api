
package com.pangea.cita_api.repository;

import com.pangea.cita_api.models.Horario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHorarioRepo extends IGenericRepo<Horario, Long> {

    // Paginado de horarios disponibles de un médico específico
    Page<Horario> findByMedico_MedicoIdAndDisponibleTrue(Long medicoId, Pageable pageable);

}
