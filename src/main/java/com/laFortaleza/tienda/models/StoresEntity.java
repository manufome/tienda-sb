package com.laFortaleza.tienda.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "almacenes", schema = "tienda", catalog = "")
public class StoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_almacen")
    private int idAlmacen;
    @Basic
    @Column(name = "nombre_almacen")
    private String nombreAlmacen;
    @Basic
    @Column(name = "id_ubicacion")
    private Integer idUbicacion;

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoresEntity that = (StoresEntity) o;
        return idAlmacen == that.idAlmacen && Objects.equals(nombreAlmacen, that.nombreAlmacen) && Objects.equals(idUbicacion, that.idUbicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlmacen, nombreAlmacen, idUbicacion);
    }
}
