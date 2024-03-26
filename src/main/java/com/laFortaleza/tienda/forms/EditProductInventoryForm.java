package com.laFortaleza.tienda.forms;

import com.laFortaleza.tienda.models.ProductsEntity;
import com.laFortaleza.tienda.models.inventories.InventoriesEntity;


public record EditProductInventoryForm(ProductsEntity product, InventoriesEntity inventory) {
}
