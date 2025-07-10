package com.pangea.cita_api.models;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "hora_establecida", nullable = false)
    private Instant horaEstablecida;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @Column(nullable = false)
    private Boolean disponible;
}
