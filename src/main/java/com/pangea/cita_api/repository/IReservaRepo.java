package com.pangea.cita_api.repository;

import com.pangea.cita_api.models.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Instant;
import java.util.List;

public interface IReservaRepo extends IGenericRepo<Reserva,Long> {

    @Query(value = "SELECT * FROM reservas r WHERE userId =:id",nativeQuery = true)
    List<Reserva> findUserId(@PathVariable("id") Long userId);

    List<Reserva> findByFechaReserva(@PathVariable("fecha") Instant fecha);
}
