package com.laFortaleza.tienda.models;

import java.io.Serializable;
import jakarta.persistence.Column;
public class InventoriesEntityPK implements Serializable {
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "id_almacen")
    private int idAlmacen;
}
