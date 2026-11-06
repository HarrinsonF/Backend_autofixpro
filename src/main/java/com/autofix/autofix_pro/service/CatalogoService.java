package com.autofix.autofix_pro.service;

import com.autofix.autofix_pro.entity.RepuestosServicios;
import com.autofix.autofix_pro.exception.RecursoNoEncontradoException;
import com.autofix.autofix_pro.repository.RepuestosServiciosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoService {

    private final RepuestosServiciosRepository repository;

    public CatalogoService(RepuestosServiciosRepository repository) {
        this.repository = repository;
    }

    public List<RepuestosServicios> listarTodos() {
        return repository.findAll();
    }

    public RepuestosServicios obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Ítem de catálogo no encontrado con ID: " + id));
    }

    public RepuestosServicios registrar(RepuestosServicios item) {
        if (repository.existsByCodigoSkuIgnoreCase(item.getCodigoSku())) {
            throw new IllegalArgumentException("El código SKU " + item.getCodigoSku() + " ya está registrado.");
        }
        return repository.save(item);
    }

    public RepuestosServicios actualizar(Long id, RepuestosServicios detalles) {
        RepuestosServicios existente = obtenerPorId(id);
        existente.setCodigoSku(detalles.getCodigoSku());
        existente.setTipoCatalogo(detalles.getTipoCatalogo());
        existente.setPrecioUnitario(detalles.getPrecioUnitario());
        existente.setStockActual(detalles.getStockActual());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        RepuestosServicios existente = obtenerPorId(id);
        repository.delete(existente);
    }
}
