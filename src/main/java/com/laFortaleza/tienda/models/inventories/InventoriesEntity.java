package com.laFortaleza.tienda.models.inventories;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "inventarios", schema = "tienda", catalog = "")
@IdClass(InventoriesEntityPK.class)
public class InventoriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_producto")
    private int idProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_almacen")
    private int idAlmacen;

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Basic
    @Column(name = "cantidad")
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "alerta")
    private Integer alerta;

    public Integer getAlerta() {
        return alerta;
    }

    public void setAlerta(Integer alerta) {
        this.alerta = alerta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoriesEntity that = (InventoriesEntity) o;
        return idProducto == that.idProducto && idAlmacen == that.idAlmacen && cantidad == that.cantidad && Objects.equals(alerta, that.alerta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idAlmacen, cantidad, alerta);
    }
}
