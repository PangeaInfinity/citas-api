package com.pangea.cita_api.service;

import com.pangea.cita_api.models.MiReserva;
import com.pangea.cita_api.models.Usuario;

import java.util.List;

public interface IMiReservaService {

    List<MiReserva> obtenerReservasPorUsuario(Usuario usuario);

    MiReserva guardarReserva(MiReserva reserva);
}

