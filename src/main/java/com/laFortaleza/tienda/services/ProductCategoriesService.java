package com.laFortaleza.tienda.services;

import com.laFortaleza.tienda.models.ProductCategoriesEntity;
import com.laFortaleza.tienda.repositories.ProductCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductCategoriesService {
    @Autowired
    ProductCategoriesRepository productCategoriesRepository;

    public List<ProductCategoriesEntity> getCategories(){
        return productCategoriesRepository.findAll();
    }
}