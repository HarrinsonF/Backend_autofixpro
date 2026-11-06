package com.autofix.autofix_pro.repository;

import com.autofix.autofix_pro.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    boolean existsByPlacaIgnoreCase(String placa);
    Optional<Vehiculo> findByPlacaIgnoreCase(String placa);
}
