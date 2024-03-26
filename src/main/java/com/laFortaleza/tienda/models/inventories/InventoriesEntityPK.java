package com.laFortaleza.tienda.models.inventories;

import java.io.Serializable;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
public class InventoriesEntityPK implements Serializable {
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "id_almacen")
    private int idAlmacen;
}
