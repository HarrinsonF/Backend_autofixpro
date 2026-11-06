package com.autofix.autofix_pro.controller;

import com.autofix.autofix_pro.entity.Repuesto;
import com.autofix.autofix_pro.service.RepuestoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {

    private final RepuestoService service;

    public RepuestoController(RepuestoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Repuesto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repuesto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Repuesto> registrar(@Valid @RequestBody Repuesto repuesto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(repuesto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Repuesto> actualizar(@PathVariable Long id, @Valid @RequestBody Repuesto repuesto) {
        return ResponseEntity.ok(service.actualizar(id, repuesto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
