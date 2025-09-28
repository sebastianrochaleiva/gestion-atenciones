package com.example.gestion_atenciones.service.impl;

import org.springframework.stereotype.Service;

import com.example.gestion_atenciones.entity.Paciente;
import com.example.gestion_atenciones.repository.PacienteRepository;
import com.example.gestion_atenciones.service.PacienteService;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> obtenerPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente actualizar(Long id, Paciente paciente) {
        if (pacienteRepository.existsById(id)) {
            paciente.setId(id);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}

