package com.laFortaleza.tienda.models;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "categorias_productos", schema = "tienda", catalog = "")
public class ProductCategoriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categoria")
    private int idCategoria;
    @Basic
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    @Basic
    @Column(name = "img_categoria")
    private byte[] imgCategoria;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public byte[] getImgCategoria() {
        return imgCategoria;
    }

    public void setImgCategoria(byte[] imgCategoria) {
        this.imgCategoria = imgCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoriesEntity that = (ProductCategoriesEntity) o;
        return idCategoria == that.idCategoria && Objects.equals(nombreCategoria, that.nombreCategoria) && Arrays.equals(imgCategoria, that.imgCategoria);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idCategoria, nombreCategoria);
        result = 31 * result + Arrays.hashCode(imgCategoria);
        return result;
    }
}
