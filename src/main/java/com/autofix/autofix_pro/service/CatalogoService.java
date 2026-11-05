package com.autofix.autofix_pro.service;

import com.autofix.autofix_pro.entity.RepuestosServicios;
import com.autofix.autofix_pro.repository.RepuestosServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CatalogoService {

    @Autowired
    private RepuestosServiciosRepository repository;

    public List<RepuestosServicios> listarTodos() {
        return repository.findAll();
    }

    public RepuestosServicios registrarItem(RepuestosServicios item) {
        // Regla de negocio (HU-02): Validar que el precio y stock no sean negativos
        if (item.getPrecioUnitario().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio unitario no puede ser negativo.");
        }
        if (item.getStockActual() < 0) {
            throw new IllegalArgumentException("El stock actual no puede ser negativo.");
        }

        return repository.save(item);
    }
}