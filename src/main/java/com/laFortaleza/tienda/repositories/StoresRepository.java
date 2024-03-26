package com.laFortaleza.tienda.repositories;

import com.laFortaleza.tienda.models.StoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoresRepository extends JpaRepository<StoresEntity, Integer> {
    StoresEntity findByNombreAlmacen(String name);
}
