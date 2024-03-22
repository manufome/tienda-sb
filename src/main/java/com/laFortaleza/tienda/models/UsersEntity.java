package com.laFortaleza.tienda.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuarios", schema = "tienda", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic
    @Column(name = "nombre_usuario")
    private String username;
    @Basic
    @Column(name = "contraseña")
    private String password;
    @Basic
    @Column(name = "rol")
    private Object rol;
    @Basic
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Basic
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic
    @Column(name = "reset_token")
    private String resetToken;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getRol() {
        return rol;
    }

    public void setRol(Object rol) {
        this.rol = rol;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return idUsuario == that.idUsuario && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(rol, that.rol) && Objects.equals(idCliente, that.idCliente) && Objects.equals(idEmpleado, that.idEmpleado) && Objects.equals(resetToken, that.resetToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, username, password, rol, idCliente, idEmpleado, resetToken);
    }
}
