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
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private Long reservaId;

    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false, referencedColumnName = "usuario_id")
    private Usuario usuario;

    @Column(name = "fecha_reserva")
    private Instant fechaReserva = Instant.now();

    @Column(name = "consulta", length = 1024)
    private String consulta;

    @OneToOne
    @JoinColumn(name = "horario_id", nullable = false, referencedColumnName = "horario_id")
    private Horario horario;
}
