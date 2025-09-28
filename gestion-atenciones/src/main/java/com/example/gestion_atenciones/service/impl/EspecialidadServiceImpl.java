package com.example.gestion_atenciones.service.impl;

import org.springframework.stereotype.Service;

import com.example.gestion_atenciones.entity.Especialidad;
import com.example.gestion_atenciones.repository.EspecialidadRepository;
import com.example.gestion_atenciones.service.EspecialidadService;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public List<Especialidad> listar() {
        return especialidadRepository.findAll();
    }

    @Override
    public Optional<Especialidad> obtenerPorId(Long id) {
        return especialidadRepository.findById(id);
    }

    @Override
    public Especialidad guardar(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad actualizar(Long id, Especialidad especialidad) {
        if (especialidadRepository.existsById(id)) {
            especialidad.setId(id);
            return especialidadRepository.save(especialidad);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        especialidadRepository.deleteById(id);
    }
}

