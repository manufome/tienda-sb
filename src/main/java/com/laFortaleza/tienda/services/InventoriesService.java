package com.laFortaleza.tienda.services;

import com.laFortaleza.tienda.dto.ProductInventoryDTO;
import com.laFortaleza.tienda.repositories.InventoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoriesService {
    @Autowired
    InventoriesRepository inventoriesRepository;
    public List<ProductInventoryDTO> getProducts() {
        return inventoriesRepository.getProductsWithInventory();
    }
}
