package com.pangea.cita_api.controller;

import com.pangea.cita_api.config.mapper.ReservaMapper;
import com.pangea.cita_api.dto.request.ReservaRequestDTO;
import com.pangea.cita_api.dto.response.ReservaResponseDTO;
import com.pangea.cita_api.service.IReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pangea.cita_api.models.Reserva;


import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final IReservaService reservaService;

    public ReservaController(IReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crearReserva(@RequestBody ReservaRequestDTO request) {
        Reserva reserva = ReservaMapper.toEntity(request, request.getHorarioId(), request.getUsuarioId());
        Reserva guardada = reservaService.save(reserva);
        ReservaResponseDTO response = ReservaMapper.toDTO(guardada);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> listarReservas() {
        List<ReservaResponseDTO> lista = reservaService.findAll()
                .stream()
                .map(ReservaMapper::toDTO)
                .toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerReserva(@PathVariable("id") Long id) {
        return reservaService.findById(id)
                .map(reserva -> ResponseEntity.ok(ReservaMapper.toDTO(reserva)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable("id") Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<ReservaResponseDTO>> obtenerReservaByUserId(@PathVariable("id") Long userId){
        List<ReservaResponseDTO> list = reservaService.findUserId(userId)
                .stream()
                .map(ReservaMapper::toDTO)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<ReservaResponseDTO>> obtenerReservaByDate(@PathVariable("date") Instant date){
        List<ReservaResponseDTO> list = reservaService.findByFechaReserva(date)
                .stream()
                .map(ReservaMapper::toDTO)
                .toList();
        return ResponseEntity.ok(list);
    }
}
