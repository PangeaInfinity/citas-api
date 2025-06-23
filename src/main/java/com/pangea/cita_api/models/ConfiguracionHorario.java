package com.pangea.cita_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "configuraciones_horario")
public class ConfiguracionHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "configuracion_horario_id")
    private Long configuracionHorarioId;

    private String configuracionNombre;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    private LocalTime descansoInicio;

    private LocalTime descansoFin;

    private Integer tiempoConsulta;

    private Integer tiempoIntermedio;

    @Enumerated(EnumType.STRING)
    private List<Dia> dias;
}
