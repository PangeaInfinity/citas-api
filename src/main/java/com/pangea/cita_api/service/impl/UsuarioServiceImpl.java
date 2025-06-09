package com.pangea.cita_api.service.impl;

import com.pangea.cita_api.models.Usuario;
import com.pangea.cita_api.repository.IGenericRepo;
import com.pangea.cita_api.repository.IUsuarioRepo;
import com.pangea.cita_api.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends CRUDServiceImpl<Usuario,Long> implements IUsuarioService {

    @Autowired
    private IUsuarioRepo repository;

    @Override
    protected IGenericRepo<Usuario, Long> getRepo() {
        return repository;
    }
}
