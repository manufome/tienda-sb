package com.laFortaleza.tienda.services;

import com.laFortaleza.tienda.models.ProductsEntity;
import com.laFortaleza.tienda.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.tomcat.util.codec.binary.Base64;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;
    public List<ProductsEntity> getProductos(){
        return productsRepository.findAll();
    }

    public Optional<ProductsEntity> getProducto(int id){
        return productsRepository.findById(id);
    }

    public ProductsEntity saveOrUpdate(ProductsEntity product){
        System.out.println("Product: " + product.getIdProducto());
        return productsRepository.save(product);
    }

    public void delete(int id){
        productsRepository.deleteById(id);
    }
}
