package com.pangea.cita_api.controller;

import com.pangea.cita_api.config.mapper.MedicoMapper;
import com.pangea.cita_api.dto.request.MedicoRequestDTO;
import com.pangea.cita_api.dto.response.MedicoResponseDTO;
import com.pangea.cita_api.models.Medico;
import com.pangea.cita_api.service.IMedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//anotations
@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    //attributes
    private final IMedicoService medicoService;

    public MedicoController(IMedicoService medicoService) {
        this.medicoService=medicoService;
    }//end constructor

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> create(@RequestBody MedicoRequestDTO dto) {
        Medico medico = MedicoMapper.toEntity(dto);
        Medico guardar = medicoService.save(medico);
        MedicoResponseDTO response = MedicoMapper.toDTO(guardar);
        return ResponseEntity.ok(response);
    }//end method post

    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> listar() {
        List<MedicoResponseDTO> lista = medicoService.findAll()
                .stream()
                .map(MedicoMapper::toDTO)
                .toList();
        return ResponseEntity.ok(lista);
    }//end method get

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> obtener(@PathVariable("id") Long id) {
        return medicoService.findById(id)
                .map(medico -> ResponseEntity.ok(MedicoMapper.toDTO(medico)))
                .orElse(ResponseEntity.notFound().build());
    }//end method get for id

    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> actualizar(@PathVariable("id") Long id, @RequestBody MedicoRequestDTO dto) {
        Medico medico = MedicoMapper.toEntity(dto);
        medico.setMedicoId(id);
        Medico actualizado = medicoService.update(medico);
        return ResponseEntity.ok(MedicoMapper.toDTO(actualizado));
    }//end method put

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) {
        medicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }//end method delete


}//end controller
