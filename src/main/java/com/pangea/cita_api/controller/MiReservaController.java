package com.pangea.cita_api.controller;

import com.pangea.cita_api.config.mapper.MiReservaMapper;
import com.pangea.cita_api.dto.response.MiReservaResponseDTO;
import com.pangea.cita_api.models.Usuario;
import com.pangea.cita_api.services.IMiReservaService;
import com.pangea.cita_api.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mis-reservas")
public class MiReservaController {

    private final IMiReservaService miReservaService;
    private final MiReservaMapper miReservaMapper;
    private final UsuarioService usuarioService;

    public MiReservaController(IMiReservaService miReservaService,
                               MiReservaMapper miReservaMapper,
                               UsuarioService usuarioService) {
        this.miReservaService = miReservaService;
        this.miReservaMapper = miReservaMapper;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<MiReservaResponseDTO>> getReservasPorUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        List<MiReservaResponseDTO> reservasDTO = miReservaService.obtenerReservasPorUsuario(usuario)
                .stream()
                .map(miReservaMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservasDTO);
    }
}
