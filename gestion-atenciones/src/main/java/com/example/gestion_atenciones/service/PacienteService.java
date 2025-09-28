package com.example.gestion_atenciones.service;

import com.example.gestion_atenciones.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    List<Paciente> listar();
    Optional<Paciente> obtenerPorId(Long id);
    Paciente guardar(Paciente paciente);
    Paciente actualizar(Long id, Paciente paciente);
    void eliminar(Long id);
}

