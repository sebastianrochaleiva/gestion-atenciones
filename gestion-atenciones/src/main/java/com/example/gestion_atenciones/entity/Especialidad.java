package com.example.gestion_atenciones.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "especialidades")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Builder.Default
    private Boolean estado = true;
}

