package com.autofix.autofix_pro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "repuestos_servicios")
public class RepuestosServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El código SKU es obligatorio")
    @Column(name = "codigo_sku", unique = true, nullable = false, length = 30)
    private String codigoSku;

    @NotBlank(message = "El tipo de catálogo es obligatorio (REPUESTO o SERVICIO_MANO_OBRA)")
    @Column(name = "tipo_catalogo", nullable = false, length = 25)
    private String tipoCatalogo;

    @NotNull(message = "El precio unitario es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio unitario no puede ser negativo ni cero")
    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @NotNull(message = "El stock actual es obligatorio")
    @Min(value = 0, message = "El stock actual no puede ser negativo")
    @Column(name = "stock_actual", nullable = false)
    private Integer stockActual;

    public RepuestosServicios() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigoSku() { return codigoSku; }
    public void setCodigoSku(String codigoSku) { this.codigoSku = codigoSku; }

    public String getTipoCatalogo() { return tipoCatalogo; }
    public void setTipoCatalogo(String tipoCatalogo) { this.tipoCatalogo = tipoCatalogo; }

    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }

    public Integer getStockActual() { return stockActual; }
    public void setStockActual(Integer stockActual) { this.stockActual = stockActual; }
}
