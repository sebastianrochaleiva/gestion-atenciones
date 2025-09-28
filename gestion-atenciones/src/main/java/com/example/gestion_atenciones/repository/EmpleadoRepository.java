package com.example.gestion_atenciones.repository;

import com.example.gestion_atenciones.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByRol(String rol);
}

