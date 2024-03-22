package com.laFortaleza.tienda.repositories;

import com.laFortaleza.tienda.models.ProductCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategoriesEntity, Integer>{
}
