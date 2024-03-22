package com.laFortaleza.tienda.repositories;

import com.laFortaleza.tienda.models.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer>{

}
