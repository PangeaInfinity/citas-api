package com.pangea.cita_api.repository;

import com.pangea.cita_api.models.Usuario;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepo extends IGenericRepo<Usuario,Long> {

    @Query(value = "SELECT u.name FROM usuarios u WHERE u.email :=email", nativeQuery = true)
    Optional<Usuario> findByEmail(String email);

    @Query(value = "SELECT u FROM usuarios u WHERE u.name LIKE %:=search%", nativeQuery = true)
    List<Usuario> search(String search);
}
