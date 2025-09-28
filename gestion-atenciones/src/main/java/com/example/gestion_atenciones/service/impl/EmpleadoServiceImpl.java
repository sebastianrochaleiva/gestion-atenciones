package com.example.gestion_atenciones.service.impl;

import com.example.gestion_atenciones.entity.Empleado;
import com.example.gestion_atenciones.repository.EmpleadoRepository;
import com.example.gestion_atenciones.service.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> listar() {
        return empleadoRepository.findAll();
    }

    @Override
    public List<Empleado> listarPorRol(String rol) {
        return empleadoRepository.findByRol(rol);
    }

    @Override
    public Optional<Empleado> obtenerPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public Empleado actualizar(Long id, Empleado empleado) {
        Optional<Empleado> optionalEmpleado = empleadoRepository.findById(id);
        if (optionalEmpleado.isPresent()) {
            Empleado existente = optionalEmpleado.get();
            existente.setPersona(empleado.getPersona());
            existente.setRol(empleado.getRol());
            return empleadoRepository.save(existente);
        } else {
            throw new RuntimeException("Empleado no encontrado con id: " + id);
        }
    }
}
