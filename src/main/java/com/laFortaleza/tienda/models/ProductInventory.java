package com.laFortaleza.tienda.models;

import lombok.Getter;

import java.math.BigDecimal;

public class ProductInventory {
    @Getter
    private int idProducto;
    @Getter
    private String nombreProducto;
    @Getter
    private String nombreCategoria;
    @Getter
    private BigDecimal precioVenta;
    @Getter
    private int stock;
    @Getter
    private String nombreAlmacen;
    @Getter
    private int alerta;

    public ProductInventory(Object[] productArray) {
        this.idProducto = (int) productArray[0];
        this.nombreProducto = (String) productArray[1];
        this.nombreCategoria = (String) productArray[2];
        this.precioVenta = (BigDecimal) productArray[3];
        this.stock = (int) productArray[4];
        this.nombreAlmacen = (String) productArray[5];
        this.alerta = (int) productArray[6];
    }

}