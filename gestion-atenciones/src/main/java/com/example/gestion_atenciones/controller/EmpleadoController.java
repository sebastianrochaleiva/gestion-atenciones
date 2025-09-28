package com.example.gestion_atenciones.controller;

import com.example.gestion_atenciones.entity.Empleado;
import com.example.gestion_atenciones.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> listar() {
        return ResponseEntity.ok(empleadoService.listar());
    }

    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<Empleado>> listarPorRol(@PathVariable String rol) {
        return ResponseEntity.ok(empleadoService.listarPorRol(rol));
    }

    @PostMapping
    public ResponseEntity<Empleado> crear(@Valid @RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoService.guardar(empleado));
    }
}
