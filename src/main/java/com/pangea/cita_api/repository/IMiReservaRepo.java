package com.pangea.cita_api.repository;

import com.pangea.cita_api.models.MiReserva;
import com.pangea.cita_api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMiReservaRepo extends JpaRepository<MiReserva, Long> {

    List<MiReserva> findByUsuario(Usuario usuario);
}

