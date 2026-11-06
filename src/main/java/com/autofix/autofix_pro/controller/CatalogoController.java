package com.autofix.autofix_pro.controller;

import com.autofix.autofix_pro.entity.RepuestosServicios;
import com.autofix.autofix_pro.service.CatalogoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalogo-items")
public class CatalogoController {

    private final CatalogoService service;

    public CatalogoController(CatalogoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RepuestosServicios>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepuestosServicios> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<RepuestosServicios> registrar(@Valid @RequestBody RepuestosServicios item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepuestosServicios> actualizar(@PathVariable Long id, @Valid @RequestBody RepuestosServicios detalles) {
        return ResponseEntity.ok(service.actualizar(id, detalles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
