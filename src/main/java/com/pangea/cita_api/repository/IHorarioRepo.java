package com.pangea.cita_api.repository;

import com.pangea.cita_api.models.Horario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IHorarioRepo extends IGenericRepo<Horario, Long> {

    // Query nativa con paginado
   @Query(
  value = "SELECT * FROM horarios WHERE medico_id = :medicoId AND disponible = true ORDER BY hora_establecida ASC",
  countQuery = "SELECT COUNT(*) FROM horarios WHERE medico_id = :medicoId AND disponible = true",
  nativeQuery = true
)
Page<Horario> buscarHorariosDisponiblesPorMedico(@Param("medicoId") Long medicoId, Pageable pageable);
}
