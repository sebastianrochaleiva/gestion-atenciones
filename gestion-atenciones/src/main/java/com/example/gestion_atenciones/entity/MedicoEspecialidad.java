package com.example.gestion_atenciones.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medico_especialidades")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MedicoEspecialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;
}

