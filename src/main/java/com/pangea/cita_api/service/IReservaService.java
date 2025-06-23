package com.pangea.cita_api.service;

import com.pangea.cita_api.models.Reserva;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface IReservaService extends ICRUDService<Reserva,Long> {
    List<Reserva> findUserId(@Param("id") Long userId);
    List<Reserva> findByFechaReserva(@Param("fecha") Instant fecha);
}
