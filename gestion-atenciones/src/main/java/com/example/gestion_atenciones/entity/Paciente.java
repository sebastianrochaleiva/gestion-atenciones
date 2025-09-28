package com.example.gestion_atenciones.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pacientes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private String rol = "PACIENTE";

    @Builder.Default
    private Boolean estado = true;

    @OneToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
}

