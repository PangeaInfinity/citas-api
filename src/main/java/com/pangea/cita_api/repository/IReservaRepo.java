package com.pangea.cita_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import com.pangea.cita_api.models.Reserva;


import java.time.Instant;
import java.util.List;


public interface IReservaRepo extends IGenericRepo<Reserva,Long> {

    @Query(value = "SELECT * FROM reserva r WHERE usuario_id =:id",nativeQuery = true)
    List<Reserva> findUserId(@Param("id") Long userId);

    List<Reserva> findByFechaReserva(@Param("fecha") Instant fecha);

    @Query(value = "SELECT * FROM reserva r WHERE  r.medico_id = :id",nativeQuery = true)
    List<Reserva> findByMedicoId(@Param("id") Long medicoId);
}
