package com.pangea.cita_api.controller;

import com.pangea.cita_api.config.mapper.ReservaMapper;
import com.pangea.cita_api.dto.request.ReservaRequestDTO;
import com.pangea.cita_api.dto.response.ReservaResponseDTO;
import com.pangea.cita_api.models.Reserva;
import com.pangea.cita_api.service.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final IReservaService reservaService;
    private final ReservaMapper reservaMapper;

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crearReserva(@RequestBody ReservaRequestDTO request) {
        Reserva reserva = reservaMapper.toEntity(request);
        Reserva guardada = reservaService.save(reserva);
        ReservaResponseDTO response = reservaMapper.toDto(guardada);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> listarReservas() {
        List<ReservaResponseDTO> lista = reservaService.findAll()
                .stream()
                .map(reservaMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerReserva(@PathVariable Long id) {
        return reservaService.findById(id)
                .map(reserva -> ResponseEntity.ok(reservaMapper.toDto(reserva)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
