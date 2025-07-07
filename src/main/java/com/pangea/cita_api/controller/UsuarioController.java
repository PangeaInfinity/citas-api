package com.pangea.cita_api.controller;

import com.pangea.cita_api.config.mapper.UsuarioMapper;
import com.pangea.cita_api.dto.request.UsuarioRequestDTO;
import com.pangea.cita_api.dto.response.UsuarioResponseDTO;
import com.pangea.cita_api.models.Usuario;
import com.pangea.cita_api.service.IUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody @Valid UsuarioRequestDTO dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);
        Usuario guardado = usuarioService.save(usuario);
        UsuarioResponseDTO response = UsuarioMapper.toDTO(guardado);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        List<UsuarioResponseDTO> lista = usuarioService.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuario(@PathVariable("id") Long id) {
        return usuarioService.findById(id)
                .map(UsuarioMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
