package com.pangea.cita_api.controller;

import com.pangea.cita_api.config.mapper.UsuarioMapper;
import com.pangea.cita_api.dto.request.UsuarioRequestDTO;
import com.pangea.cita_api.dto.response.UsuarioResponseDTO;
import com.pangea.cita_api.models.Usuario;
import com.pangea.cita_api.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @Autowired
    private UsuarioMapper mapper;

    @PostMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> createUser(UsuarioRequestDTO requestDTO, @PathVariable("id") Long id){
        Usuario usuario = service.save(mapper.toEntity(requestDTO));
        UsuarioResponseDTO res = mapper.toDto(usuario);
        return ResponseEntity.ok(res);
    }
}
