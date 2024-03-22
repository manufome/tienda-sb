package com.laFortaleza.tienda.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductInventoryDTO {
    private int idProducto;
    private String nombreProducto;
    private String nombreCategoria;
    private BigDecimal precioVenta;
    private int stock;
    private String nombreAlmacen;
    private int alerta;

    public ProductInventoryDTO(int id, String nombreProducto, String nombreCategoria, BigDecimal precioVenta, int stock, String nombreAlmacen, int alerta) {
        this.idProducto = id;
        this.nombreProducto = nombreProducto;
        this.nombreCategoria = nombreCategoria;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.nombreAlmacen = nombreAlmacen;
        this.alerta = alerta;
    }

}