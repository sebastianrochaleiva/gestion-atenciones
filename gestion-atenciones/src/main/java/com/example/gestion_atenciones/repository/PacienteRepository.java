package com.example.gestion_atenciones.repository;

import com.example.gestion_atenciones.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}

