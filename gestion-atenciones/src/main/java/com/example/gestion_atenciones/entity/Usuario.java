package com.example.gestion_atenciones.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = "usuario")
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String usuario;

    @NotBlank
    private String contrasena;

    @OneToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
}

