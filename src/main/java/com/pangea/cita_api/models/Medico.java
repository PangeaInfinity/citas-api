package com.pangea.cita_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="medicos")
public class Medico {
    //attributes private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_id")
    private Long medicoId;

    private String nombre;

    private String especialidad;

    //relationship
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

}
