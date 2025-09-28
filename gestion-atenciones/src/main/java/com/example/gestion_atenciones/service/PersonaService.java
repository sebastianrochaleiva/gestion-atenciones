package com.example.gestion_atenciones.service;

import com.example.gestion_atenciones.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> listar();
    Optional<Persona> obtenerPorId(Long id);
    Persona guardar(Persona persona);
    Persona actualizar(Long id, Persona persona);
    void eliminar(Long id);
}

