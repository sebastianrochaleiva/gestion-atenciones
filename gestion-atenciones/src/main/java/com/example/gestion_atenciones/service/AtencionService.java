package com.example.gestion_atenciones.service;

import com.example.gestion_atenciones.entity.Atencion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AtencionService {
    List<Atencion> listar();
    Optional<Atencion> obtenerPorId(Long id);
    Atencion guardar(Atencion atencion);
    Atencion actualizar(Long id, Atencion atencion);
    void eliminar(Long id);

    List<Atencion> buscarPorFecha(LocalDateTime inicio, LocalDateTime fin);
    List<Atencion> buscarPorEmpleado(Long empleadoId);
}
