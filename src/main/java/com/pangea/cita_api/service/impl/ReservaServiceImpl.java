package com.pangea.cita_api.service.impl;

import com.pangea.cita_api.models.Reserva;
import com.pangea.cita_api.repository.IGenericRepo;
import com.pangea.cita_api.repository.IReservaRepo;
import com.pangea.cita_api.service.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl extends CRUDServiceImpl<Reserva,Long> implements IReservaService {

    private final IReservaRepo repo;

    @Override
    public List<Reserva> findUserId(Long userId) {
        return repo.findUserId(userId);
    }

    @Override
    public List<Reserva> findByFechaReserva(Instant fecha) {
        return repo.findByFechaReserva(fecha);
    }

    @Override
    protected IGenericRepo<Reserva, Long> getRepo() {
        return null;
    }
}
