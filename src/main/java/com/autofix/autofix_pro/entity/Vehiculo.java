package com.autofix.autofix_pro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La placa es obligatoria")
    @Column(name = "placa", unique = true, nullable = false, length = 10)
    private String placa;

    @NotBlank(message = "La marca, modelo y año son obligatorios")
    @Column(name = "marca_modelo_anio", nullable = false, length = 120)
    private String marcaModeloAnio;

    @NotNull(message = "El kilometraje actual es obligatorio")
    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    @Column(name = "kilometraje_actual", nullable = false)
    private Integer kilometrajeActual;

    @NotBlank(message = "El DNI o RUC del propietario es obligatorio")
    @Column(name = "dni_ruc_cliente", nullable = false, length = 15)
    private String dniRucCliente;

    @NotBlank(message = "El nombre del cliente es obligatorio")
    @Column(name = "nombre_cliente", nullable = false, length = 150)
    private String nombreCliente;

    public Vehiculo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarcaModeloAnio() { return marcaModeloAnio; }
    public void setMarcaModeloAnio(String marcaModeloAnio) { this.marcaModeloAnio = marcaModeloAnio; }

    public Integer getKilometrajeActual() { return kilometrajeActual; }
    public void setKilometrajeActual(Integer kilometrajeActual) { this.kilometrajeActual = kilometrajeActual; }

    public String getDniRucCliente() { return dniRucCliente; }
    public void setDniRucCliente(String dniRucCliente) { this.dniRucCliente = dniRucCliente; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
}
