package com.example.gestion_atenciones.service.impl;

import org.springframework.stereotype.Service;

import com.example.gestion_atenciones.entity.Atencion;
import com.example.gestion_atenciones.repository.AtencionRepository;
import com.example.gestion_atenciones.service.AtencionService;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AtencionServiceImpl implements AtencionService {

    private final AtencionRepository atencionRepository;

    public AtencionServiceImpl(AtencionRepository atencionRepository) {
        this.atencionRepository = atencionRepository;
    }

    @Override
    public List<Atencion> listar() {
        return atencionRepository.findAll();
    }

    @Override
    public Optional<Atencion> obtenerPorId(Long id) {
        return atencionRepository.findById(id);
    }

    @Override
    public Atencion guardar(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    @Override
    public void eliminar(Long id) {
        atencionRepository.deleteById(id);
    }

    @Override
    public List<Atencion> buscarPorFecha(LocalDateTime inicio, LocalDateTime fin) {
        return atencionRepository.findByFechaBetween(inicio, fin);
    }

    @Override
    public List<Atencion> buscarPorEmpleado(Long empleadoId) {
        return atencionRepository.findByEmpleado_Id(empleadoId);
    }

    @Override
    public Atencion actualizar(Long id, Atencion atencion) {
        Optional<Atencion> existente = atencionRepository.findById(id);
        if (existente.isPresent()) {
            Atencion atencionExistente = existente.get();
            atencionExistente.setFecha(atencion.getFecha());
            atencionExistente.setEmpleado(atencion.getEmpleado());
            atencionExistente.setPaciente(atencion.getPaciente());
            atencionExistente.setMotivo(atencion.getMotivo());
            return atencionRepository.save(atencionExistente);
        } else {
            throw new RuntimeException("Atención no encontrada con id: " + id);
        }
    }
}
