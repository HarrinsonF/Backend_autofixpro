package com.autofix.autofix_pro.controller;

import com.autofix.autofix_pro.entity.Vehiculo;
import com.autofix.autofix_pro.service.VehiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Vehiculo> registrar(@Valid @RequestBody Vehiculo vehiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(vehiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizar(@PathVariable Long id, @Valid @RequestBody Vehiculo vehiculo) {
        return ResponseEntity.ok(service.actualizar(id, vehiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
