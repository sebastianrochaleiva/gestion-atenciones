package com.example.gestion_atenciones.service.impl;

import com.example.gestion_atenciones.entity.Persona;
import com.example.gestion_atenciones.repository.PersonaRepository;
import com.example.gestion_atenciones.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> obtenerPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona actualizar(Long id, Persona persona) {
        if (personaRepository.existsById(id)) {
            persona.setId(id);
            return personaRepository.save(persona);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        personaRepository.deleteById(id);
    }
}
