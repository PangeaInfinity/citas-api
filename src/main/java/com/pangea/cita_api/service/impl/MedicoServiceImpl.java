package com.pangea.cita_api.service.impl;

import com.pangea.cita_api.models.Medico;
import com.pangea.cita_api.repository.IGenericRepo;
import com.pangea.cita_api.repository.IMedicoRepo;
import com.pangea.cita_api.service.IMedicoService;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl extends CRUDServiceImpl<Medico, Long> implements IMedicoService {

    //declaration attribute
    private final IMedicoRepo repo;

    public MedicoServiceImpl(IMedicoRepo repo) {
        this.repo = repo ;
    }//end construct

    @Override
    protected IGenericRepo<Medico, Long> getRepo() {
        return repo;
    }//end method
}//end class
