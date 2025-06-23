package com.pangea.cita_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "horario_id")
    private Long horarioId;

    private Instant horaEstablecida = Instant.now();

    @ManyToOne
    @JoinColumn(name = "configuracion_horario_id", nullable = false, referencedColumnName = "configuracion_horario_id")
    private ConfiguracionHorario configuracionHorario;
}
