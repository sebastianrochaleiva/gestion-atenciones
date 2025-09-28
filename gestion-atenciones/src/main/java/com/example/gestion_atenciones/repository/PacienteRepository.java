package com.example.gestion_atenciones.repository;

import com.example.gestion_atenciones.entity.Paciente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
        Optional<Paciente> findByPersona_Id(Long personaId);
}

