package com.autofix.autofix_pro.controller;

import com.autofix.autofix_pro.entity.Vehiculo;
import com.autofix.autofix_pro.exception.RecursoNoEncontradoException;
import com.autofix.autofix_pro.repository.VehiculoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehiculos")
public class VehiculoController {

    private final VehiculoRepository repository;

    public VehiculoController(VehiculoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerPorId(@PathVariable Long id) {
        Vehiculo vehiculo = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Vehículo no encontrado con ID: " + id));
        return ResponseEntity.ok(vehiculo);
    }

    @PostMapping
    public ResponseEntity<Vehiculo> registrar(@Valid @RequestBody Vehiculo vehiculo) {
        if (repository.existsByPlacaIgnoreCase(vehiculo.getPlaca())) {
            throw new IllegalArgumentException("Regla RN-01: La placa " + vehiculo.getPlaca() + " ya se encuentra registrada.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(vehiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizar(@PathVariable Long id, @Valid @RequestBody Vehiculo detalles) {
        Vehiculo existente = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Vehículo no encontrado con ID: " + id));
        existente.setPlaca(detalles.getPlaca());
        existente.setMarcaModeloAnio(detalles.getMarcaModeloAnio());
        existente.setKilometrajeActual(detalles.getKilometrajeActual());
        existente.setDniRucCliente(detalles.getDniRucCliente());
        existente.setNombreCliente(detalles.getNombreCliente());
        return ResponseEntity.ok(repository.save(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Vehiculo existente = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Vehículo no encontrado con ID: " + id));
        repository.delete(existente);
        return ResponseEntity.noContent().build();
    }
}
