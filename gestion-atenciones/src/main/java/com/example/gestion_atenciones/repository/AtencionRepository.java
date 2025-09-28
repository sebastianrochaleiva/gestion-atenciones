package com.example.gestion_atenciones.repository;

import com.example.gestion_atenciones.entity.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AtencionRepository extends JpaRepository<Atencion, Long> {

    // Consulta personalizada: buscar atenciones por fecha
    List<Atencion> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);

    // Otra: buscar atenciones por id de médico
    List<Atencion> findByEmpleado_Id(Long empleadoId);
}

