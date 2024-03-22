package com.laFortaleza.tienda.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "productos", schema = "tienda", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto")
    private int idProducto;
    @Basic
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "precio_compra")
    private BigDecimal precioCompra;
    @Basic
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;
    @Basic
    @Column(name = "id_categoria")
    private int idCategoria;
    @Basic
    @Column(name = "img_producto")
    private byte[] imgProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public byte[] getImgProducto() {
        return imgProducto;
    }

    public void setImgProducto(byte[] imgProducto) {
        this.imgProducto = imgProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return idProducto == that.idProducto && idCategoria == that.idCategoria && Objects.equals(nombreProducto, that.nombreProducto) && Objects.equals(descripcion, that.descripcion) && Objects.equals(precioCompra, that.precioCompra) && Objects.equals(precioVenta, that.precioVenta) && Arrays.equals(imgProducto, that.imgProducto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idProducto, nombreProducto, descripcion, precioCompra, precioVenta, idCategoria);
        result = 31 * result + Arrays.hashCode(imgProducto);
        return result;
    }
}
