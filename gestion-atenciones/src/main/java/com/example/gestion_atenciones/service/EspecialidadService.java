package com.example.gestion_atenciones.service;

import com.example.gestion_atenciones.entity.Especialidad;

import java.util.List;
import java.util.Optional;

public interface EspecialidadService {
    List<Especialidad> listar();
    Optional<Especialidad> obtenerPorId(Long id);
    Especialidad guardar(Especialidad especialidad);
    Especialidad actualizar(Long id, Especialidad especialidad);
    void eliminar(Long id);
}

