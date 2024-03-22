package com.laFortaleza.tienda.controllers.rest;

import com.laFortaleza.tienda.models.ProductsEntity;
import com.laFortaleza.tienda.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/productos")
public class ProductsRestController {
    @Autowired
    private ProductsService productsService;

    @GetMapping
    public List<ProductsEntity> getAll(){
        return productsService.getProductos();
    }

    @PostMapping
    public ProductsEntity saveUpdate(@RequestBody ProductsEntity product){
        productsService.saveOrUpdate(product);
        return product;
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable("productId") int id){
        productsService.delete(id);
    }

    @GetMapping("/{productId}")
    public Optional<ProductsEntity> getById(@PathVariable("productId") int id){
        return productsService.getProducto(id);
    }

}
