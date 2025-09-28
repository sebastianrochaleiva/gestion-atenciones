package com.example.gestion_atenciones.repository;

import com.example.gestion_atenciones.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByEmail(String email);
}

