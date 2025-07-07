package com.pangea.cita_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import com.pangea.cita_api.models.Reserva;


import java.time.Instant;
import java.util.List;


public interface IReservaRepo extends IGenericRepo<Reserva,Long> {

    @Query(value = "SELECT * FROM reserva r WHERE userId =:id",nativeQuery = true)
    List<Reserva> findUserId(@PathVariable("id") Long userId);

    List<Reserva> findByFechaReserva(@PathVariable("fecha") Instant fecha);
}
