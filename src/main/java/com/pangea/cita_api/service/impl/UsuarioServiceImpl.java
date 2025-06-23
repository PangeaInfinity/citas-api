package com.pangea.cita_api.service.impl;

import com.pangea.cita_api.models.Usuario;
import com.pangea.cita_api.repository.IGenericRepo;
import com.pangea.cita_api.repository.IUsuarioRepo;
import com.pangea.cita_api.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CRUDServiceImpl<Usuario,Long> implements IUsuarioService {

    private final IUsuarioRepo repository;


    @Override
    protected IGenericRepo<Usuario, Long> getRepo() {
        return repository;
    }
}
