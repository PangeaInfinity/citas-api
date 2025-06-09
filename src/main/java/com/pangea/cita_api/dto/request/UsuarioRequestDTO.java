package com.pangea.cita_api.dto.request;

import lombok.Data;

@Data
public class UsuarioRequestDTO {
    private String email;

    private String password;

    private String name;
}
