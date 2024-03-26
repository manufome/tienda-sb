package com.laFortaleza.tienda.dto;

import lombok.Getter;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;

@Getter
public class ProductInventoryDTO {
    private int idProducto;
    private String nombreProducto;
    private String nombreCategoria;
    private String imgProducto;
    private BigDecimal precioVenta;
    private int stock;
    private String nombreAlmacen;
    private int alerta;

    public ProductInventoryDTO(int id, String nombreProducto, String nombreCategoria, byte[] img, BigDecimal precioVenta, int stock, String nombreAlmacen, int alerta) {
        this.idProducto = id;
        this.nombreProducto = nombreProducto;
        this.nombreCategoria = nombreCategoria;
        this.imgProducto = Base64.encodeBase64String(img);
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.nombreAlmacen = nombreAlmacen;
        this.alerta = alerta;
    }

}