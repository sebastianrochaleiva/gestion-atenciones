package com.example.gestion_atenciones.controller;

import com.example.gestion_atenciones.entity.Atencion;
import com.example.gestion_atenciones.service.AtencionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/atenciones")
public class AtencionController {

    private final AtencionService atencionService;

    public AtencionController(AtencionService atencionService) {
        this.atencionService = atencionService;
    }

    // ADMIN: listado completo
    @GetMapping
    public ResponseEntity<List<Atencion>> listar() {
        return ResponseEntity.ok(atencionService.listar());
    }

    // PACIENTE: sus atenciones
    @GetMapping("/mias/{pacienteId}")
    public ResponseEntity<List<Atencion>> misAtenciones(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(
                atencionService.listar().stream()
                        .filter(a -> a.getPaciente().getId().equals(pacienteId))
                        .toList()
        );
    }

    // ADMIN/MEDICO: crear
    @PostMapping
    public ResponseEntity<Atencion> crear(@Valid @RequestBody Atencion atencion) {
        return ResponseEntity.ok(atencionService.guardar(atencion));
    }

    // ADMIN/MEDICO: actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Atencion> actualizar(@PathVariable Long id, @Valid @RequestBody Atencion atencion) {
        return atencionService.obtenerPorId(id)
                .map(a -> {
                    atencion.setId(id);
                    return ResponseEntity.ok(atencionService.guardar(atencion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ADMIN: eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        atencionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Consulta personalizada por fecha
    @GetMapping("/buscarPorFecha")
    public ResponseEntity<List<Atencion>> buscarPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin
    ) {
        return ResponseEntity.ok(atencionService.buscarPorFecha(inicio, fin));
    }

    // Consulta personalizada por médico
    @GetMapping("/buscarPorMedico/{empleadoId}")
    public ResponseEntity<List<Atencion>> buscarPorMedico(@PathVariable Long empleadoId) {
        return ResponseEntity.ok(atencionService.buscarPorEmpleado(empleadoId));
    }
}
