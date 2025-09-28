package com.example.gestion_atenciones.service;

import com.example.gestion_atenciones.entity.MedicoEspecialidad;

import java.util.List;
import java.util.Optional;

public interface MedicoEspecialidadService {
    List<MedicoEspecialidad> listar();
    Optional<MedicoEspecialidad> obtenerPorId(Long id);
    MedicoEspecialidad guardar(MedicoEspecialidad me);
    MedicoEspecialidad actualizar(Long id, MedicoEspecialidad me);
    void eliminar(Long id);
}

