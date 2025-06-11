package com.pangea.cita_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequestDTO {
    @Email
    @Min(3)
    @NotBlank
    private String email;

    private String password;

    @Max(15)
    private String name;
}
