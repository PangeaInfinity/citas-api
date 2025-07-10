package com.pangea.cita_api.service.impl;

import com.pangea.cita_api.models.Horario;
import com.pangea.cita_api.repository.IGenericRepo;
import com.pangea.cita_api.repository.IHorarioRepo;
import com.pangea.cita_api.service.IHorarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HorarioServiceImpl extends CRUDServiceImpl<Horario, Long> implements IHorarioService {

    private final IHorarioRepo repo;

    public HorarioServiceImpl(IHorarioRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Horario, Long> getRepo() {
        return repo;
    }

    @Override
    public Page<Horario> obtenerHorariosDisponiblesPorMedico(Long medicoId, Pageable pageable) {
        return repo.findByMedico_MedicoIdAndDisponibleTrue(medicoId, pageable);
    }
}
