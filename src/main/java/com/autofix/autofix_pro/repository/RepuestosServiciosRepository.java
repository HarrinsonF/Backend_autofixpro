package com.autofix.autofix_pro.repository;

import com.autofix.autofix_pro.entity.RepuestosServicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestosServiciosRepository extends JpaRepository<RepuestosServicios, Long> {
    // Spring Data JPA ya incluye métodos como save(), findAll(), findById() por defecto.
}