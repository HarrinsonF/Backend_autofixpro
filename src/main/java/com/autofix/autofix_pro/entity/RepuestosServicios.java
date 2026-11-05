package com.autofix.autofix_pro.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data // Anotación de Lombok que genera getters y setters en tiempo de compilación
@Entity
@Table(name = "repuestos_servicios")
public class RepuestosServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_sku", length = 30, unique = true, nullable = false)
    private String codigoSku;

    @Column(name = "tipo_catalogo", length = 20, nullable = false)
    private String tipoCatalogo; // Aquí entrará 'REPUESTO' o 'SERVICIO_MANO_OBRA'

    @Column(name = "precio_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioUnitario;

    @Column(name = "stock_actual", nullable = false)
    private Integer stockActual;
}