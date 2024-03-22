package com.laFortaleza.tienda.services;

import com.laFortaleza.tienda.models.InventoriesEntity;
import com.laFortaleza.tienda.models.ProductInventory;
import com.laFortaleza.tienda.models.ProductsEntity;
import com.laFortaleza.tienda.repositories.InventoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class InventoriesService {
    @Autowired
    InventoriesRepository inventoriesRepository;
    public List<ProductInventory> getProducts() {
        List products = inventoriesRepository.getProductsWithInventory();
        List<ProductInventory> productInventories = new ArrayList<>();
        for (Object product : products) {
            Object[] productArray = (Object[]) product;
            ProductInventory productInventory = new ProductInventory(productArray);
            productInventories.add(productInventory);
        }
        return productInventories;
    }
}
