package com.pangea.cita_api.service.impl;

import com.pangea.cita_api.models.Usuario;
import com.pangea.cita_api.repository.IGenericRepo;
import com.pangea.cita_api.repository.IUsuarioRepo;
import com.pangea.cita_api.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CRUDServiceImpl<Usuario,Long> implements IUsuarioService {

    private final IUsuarioRepo repository;


    @Override
    protected IGenericRepo<Usuario, Long> getRepo() {
        return repository;
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<Usuario> search(String search) {
        return repository.search(search);
    }
}
