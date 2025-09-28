package com.example.gestion_atenciones.controller;

import com.example.gestion_atenciones.entity.MedicoEspecialidad;
import com.example.gestion_atenciones.service.MedicoEspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico-especialidades")
@RequiredArgsConstructor
public class MedicoEspecialidadController {

    private final MedicoEspecialidadService medicoEspecialidadService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<MedicoEspecialidad>> listarTodos() {
        return ResponseEntity.ok(medicoEspecialidadService.listar());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MedicoEspecialidad> obtenerPorId(@PathVariable Long id) {
        return medicoEspecialidadService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MedicoEspecialidad> crear(@RequestBody MedicoEspecialidad medicoEspecialidad) {
        return ResponseEntity.ok(medicoEspecialidadService.guardar(medicoEspecialidad));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MedicoEspecialidad> actualizar(@PathVariable Long id, @RequestBody MedicoEspecialidad medicoEspecialidad) {
        return medicoEspecialidadService.obtenerPorId(id)
                .map(me -> {
                    medicoEspecialidad.setId(id);
                    return ResponseEntity.ok(medicoEspecialidadService.guardar(medicoEspecialidad));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        medicoEspecialidadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
