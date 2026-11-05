package com.autofix.autofix_pro.controller;

import com.autofix.autofix_pro.entity.RepuestosServicios;
import com.autofix.autofix_pro.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalogo-items")
public class CatalogoController {

    @Autowired
    private CatalogoService service;

    // Endpoint GET para listar catálogo
    @GetMapping
    public ResponseEntity<List<RepuestosServicios>> listarCatalogo() {
        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }

    // Endpoint POST para registrar un nuevo ítem
    @PostMapping
    public ResponseEntity<?> registrarItem(@RequestBody RepuestosServicios item) {
        try {
            RepuestosServicios nuevoItem = service.registrarItem(item);
            return new ResponseEntity<>(nuevoItem, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Retorna HTTP 400 con el mensaje de error si el precio o stock es negativo
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}