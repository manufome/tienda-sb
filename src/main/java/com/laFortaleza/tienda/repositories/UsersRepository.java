package com.laFortaleza.tienda.repositories;

import com.laFortaleza.tienda.dto.UserDTO;
import com.laFortaleza.tienda.models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    Optional<UsersEntity> findByUsername(String username);
    @Query(value="{ call sp_registrar_cliente(:name, :username, :email, :address, :password) }", nativeQuery = true)
    void saveUser(String name, String username, String email, String address, String password);

//    TODO: Cambiar el query para que valide el rol "cliente"
    @Query("SELECT new com.laFortaleza.tienda.dto.UserDTO(u.username, u.password, c.nombre, c.correo, c.direccion) " +
            "FROM UsersEntity u " +
            "JOIN ClientsEntity c ON u.idCliente = c.idCliente " +
            "WHERE u.username = :username")
    Optional<UserDTO> getUserInfo(@Param("username") String username);
}
