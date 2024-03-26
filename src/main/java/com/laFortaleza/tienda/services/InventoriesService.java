package com.laFortaleza.tienda.services;

import com.laFortaleza.tienda.dto.ProductInventoryDTO;
import com.laFortaleza.tienda.models.ProductsEntity;
import com.laFortaleza.tienda.models.inventories.InventoriesEntity;
import com.laFortaleza.tienda.models.inventories.InventoriesEntityPK;
import com.laFortaleza.tienda.repositories.InventoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoriesService {
    @Autowired
    InventoriesRepository inventoriesRepository;
    public List<ProductInventoryDTO> getProducts() {
        return inventoriesRepository.getProductsWithInventory();
    }

    public Optional<InventoriesEntity> getInventory(int productId, int storeId) {
        InventoriesEntityPK pk = new InventoriesEntityPK();
        pk.setIdProducto(productId);
        pk.setIdAlmacen(storeId);
        return inventoriesRepository.findById(pk);
    }
    public void deleteProduct(int id) {
        inventoriesRepository.deleteFromInventory(id);
    }

    public void saveOrUpdate(ProductsEntity product, int stock, int store) {
        InventoriesEntity inventory = new InventoriesEntity();
        inventory.setIdProducto(product.getIdProducto());
        inventory.setIdAlmacen(store);
        inventory.setCantidad(stock);
        inventory.setAlerta(5);
        inventoriesRepository.save(inventory);
    }
    public void saveOrUpdate(InventoriesEntity inventory) {
        inventoriesRepository.save(inventory);
    }
}
