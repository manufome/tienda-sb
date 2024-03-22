package com.laFortaleza.tienda.controllers.rest;

import com.laFortaleza.tienda.models.ProductCategoriesEntity;
import com.laFortaleza.tienda.models.ProductsEntity;
import com.laFortaleza.tienda.services.ProductCategoriesService;
import com.laFortaleza.tienda.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/v1/categorias")
public class CategoriesRestController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private ProductCategoriesService categoriesService;

    @GetMapping
    public List<ProductCategoriesEntity> getAll(){
        return categoriesService.getCategories();
    }

    @GetMapping("/{categoryId}/products")
    public Optional<ProductsEntity> getCategoryProducts(@PathVariable("categoryId") int id){
        return productsService.getProducto(id);
    }
}
