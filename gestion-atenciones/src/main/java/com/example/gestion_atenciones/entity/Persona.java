package com.example.gestion_atenciones.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "personas", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @Email
    @NotBlank
    private String email;

    @Builder.Default
    private Boolean estado = true;
}
