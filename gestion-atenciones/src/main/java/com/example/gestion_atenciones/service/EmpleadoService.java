package com.example.gestion_atenciones.service;

import com.example.gestion_atenciones.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> listar();
    List<Empleado> listarPorRol(String rol);
    Optional<Empleado> obtenerPorId(Long id);
    Empleado guardar(Empleado empleado);
    Empleado actualizar(Long id, Empleado empleado);
    void eliminar(Long id);
}

