package com.pangea.cita_api.service;

import com.pangea.cita_api.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService extends ICRUDService<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);
    List<Usuario> search(String search);
}
