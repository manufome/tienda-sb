package com.laFortaleza.tienda.repositories;

import com.laFortaleza.tienda.models.InventoriesEntity;
import com.laFortaleza.tienda.models.InventoriesEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InventoriesRepository extends JpaRepository<InventoriesEntity, InventoriesEntityPK> {
    @Query(value = "SELECT p.id_producto, p.nombre_producto, c.nombre_categoria, p.precio_venta, i.cantidad as stock, a.nombre_almacen, i.alerta FROM productos p, categorias_productos c, inventarios i, almacenes a WHERE p.id_categoria = c.id_categoria and p.id_producto = i.id_producto and i.id_almacen = a.id_almacen", nativeQuery = true)
    List getProductsWithInventory();
}
