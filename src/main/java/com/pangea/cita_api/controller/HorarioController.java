package com.pangea.cita_api.controller;

import com.pangea.cita_api.config.mapper.HorarioMapper;
import com.pangea.cita_api.dto.request.HorarioRequestDTO;
import com.pangea.cita_api.dto.response.HorarioResponseDTO;
import com.pangea.cita_api.models.Horario;
import com.pangea.cita_api.service.IHorarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/horarios")
@RequiredArgsConstructor
public class HorarioController {

    private final IHorarioService horarioService;

    @PostMapping
    public ResponseEntity<HorarioResponseDTO> crear(@RequestBody @Valid HorarioRequestDTO dto) {
        Horario horario = HorarioMapper.toEntity(dto);
        Horario guardado = horarioService.save(horario);
        HorarioResponseDTO response = HorarioMapper.toDTO(guardado);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<HorarioResponseDTO>> listar() {
        List<HorarioResponseDTO> lista = horarioService.findAll()
                .stream()
                .map(HorarioMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioResponseDTO> obtener(@PathVariable("id") Long id) {
        return horarioService.findById(id)
                .map(HorarioMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
