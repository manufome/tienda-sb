package com.laFortaleza.tienda.repositories;

import com.laFortaleza.tienda.dto.ProductInventoryDTO;
import com.laFortaleza.tienda.models.inventories.InventoriesEntity;
import com.laFortaleza.tienda.models.inventories.InventoriesEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InventoriesRepository extends JpaRepository<InventoriesEntity, InventoriesEntityPK> {
    @Query("SELECT new com.laFortaleza.tienda.dto.ProductInventoryDTO(p.idProducto, p.nombreProducto, c.nombreCategoria, p.imgProducto, p.precioVenta, i.cantidad, a.nombreAlmacen, i.alerta) " +
            "FROM InventoriesEntity i " +
            "JOIN ProductsEntity p ON i.idProducto = p.idProducto " +
            "JOIN ProductCategoriesEntity c ON p.idCategoria = c.idCategoria " +
            "JOIN StoresEntity a ON i.idAlmacen = a.idAlmacen")
    List<ProductInventoryDTO> getProductsWithInventory();

    @Query(value="{ call sp_eliminar_producto(:id) }", nativeQuery = true)
    void deleteFromInventory(int id);

}
