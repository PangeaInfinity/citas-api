package com.pangea.cita_api.service.impl;

import com.pangea.cita_api.dto.request.ReservaRequestDTO;
import com.pangea.cita_api.dto.response.ReservaResponseDTO;
import com.pangea.cita_api.models.Horario;
import com.pangea.cita_api.models.Reserva;
import com.pangea.cita_api.models.Usuario;
import com.pangea.cita_api.repository.IGenericRepo;
import com.pangea.cita_api.repository.IHorarioRepo;
import com.pangea.cita_api.repository.IReservaRepo;
import com.pangea.cita_api.repository.IUsuarioRepo;
import com.pangea.cita_api.service.IReservaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl extends CRUDServiceImpl<Reserva,Long> implements IReservaService {

    private final IReservaRepo repo;

    private final IHorarioRepo horarioRepo;

    private final IUsuarioRepo usuarioRepo;

    @Override
    public List<Reserva> findUserId(Long userId) {
        return repo.findUserId(userId);
    }

    @Override
    public List<Reserva> findByFechaReserva(Instant fecha) {
        return repo.findByFechaReserva(fecha);
    }

    @Transactional
    @Override
    public Reserva createReserva(ReservaRequestDTO dto) {
        Usuario usuario = usuarioRepo.findById(dto.getUsuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + dto.getUsuarioId()));

        Horario horario = horarioRepo.findById(dto.getHorarioId())
                .orElseThrow(() -> new EntityNotFoundException("Horario no encontrado con ID: " + dto.getHorarioId()));

        Reserva reserva = new Reserva();
        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setConsulta(dto.getConsulta());
        reserva.setUsuario(usuario);
        reserva.setHorario(horario);

        return repo.save(reserva);
    }

    @Override
    protected IGenericRepo<Reserva, Long> getRepo() {
        return null;
    }
}
