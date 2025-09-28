package com.example.gestion_atenciones.service.impl;

import org.springframework.stereotype.Service;

import com.example.gestion_atenciones.entity.MedicoEspecialidad;
import com.example.gestion_atenciones.repository.MedicoEspecialidadRepository;
import com.example.gestion_atenciones.service.MedicoEspecialidadService;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoEspecialidadServiceImpl implements MedicoEspecialidadService {

    private final MedicoEspecialidadRepository medicoEspecialidadRepository;

    public MedicoEspecialidadServiceImpl(MedicoEspecialidadRepository medicoRepository) {
        this.medicoEspecialidadRepository = medicoRepository;
    }

    @Override
    public List<MedicoEspecialidad> listar() {
        return medicoEspecialidadRepository.findAll();
    }

    @Override
    public Optional<MedicoEspecialidad> obtenerPorId(Long id) {
        return medicoEspecialidadRepository.findById(id);
    }

    @Override
    public MedicoEspecialidad guardar(MedicoEspecialidad medico) {
        return medicoEspecialidadRepository.save(medico);
    }

    @Override
    public MedicoEspecialidad actualizar(Long id, MedicoEspecialidad medico) {
        if (medicoEspecialidadRepository.existsById(id)) {
            medico.setId(id);
            return medicoEspecialidadRepository.save(medico);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        medicoEspecialidadRepository.deleteById(id);
    }
}

