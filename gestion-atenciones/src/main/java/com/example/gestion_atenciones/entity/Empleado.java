package com.example.gestion_atenciones.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empleados")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rol; // MEDICO, ADMIN

    @Builder.Default
    private Boolean estado = true;

    @OneToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
}

