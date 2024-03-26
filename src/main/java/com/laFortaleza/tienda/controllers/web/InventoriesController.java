package com.laFortaleza.tienda.controllers.web;

import com.laFortaleza.tienda.forms.EditProductInventoryForm;
import com.laFortaleza.tienda.models.ProductsEntity;
import com.laFortaleza.tienda.models.inventories.InventoriesEntity;
import com.laFortaleza.tienda.services.InventoriesService;
import com.laFortaleza.tienda.services.ProductCategoriesService;
import com.laFortaleza.tienda.services.ProductsService;
import com.laFortaleza.tienda.services.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class InventoriesController {
    @Autowired
    private InventoriesService inventoriesService;
    @Autowired
    private ProductCategoriesService categoriesService;
    @Autowired
    private StoresService storesService;
    @Autowired
    private ProductsService productsService;

    @GetMapping("/inventario")
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView("administrador/inventarios");
        modelAndView.addObject("products", inventoriesService.getProducts());
        return modelAndView;
    }

    @GetMapping("/inventario/agregar")
    public ModelAndView getProductForm() {
        ModelAndView modelAndView = new ModelAndView("administrador/productos/agregar");
        modelAndView.addObject("categorias", categoriesService.getCategories());
        modelAndView.addObject("almacenes", storesService.getStores());
        modelAndView.addObject("producto", new ProductsEntity());
        return modelAndView;
    }

    @PostMapping("/inventario/agregar")
    public String saveUpdate(@ModelAttribute ProductsEntity product,
                                     @RequestParam("stock") int stock,
                                     @RequestParam("almacen") int store,
                                     @RequestParam("imagen") MultipartFile image) throws Exception {
        product.setImgProducto(image.getBytes());
        ProductsEntity newProduct = productsService.saveOrUpdate(product);
        inventoriesService.saveOrUpdate(newProduct, stock, store);
        return "redirect:/inventario";
    }

    @GetMapping("/inventario/{id}/editar")
    public ModelAndView getProductEditForm(@PathVariable("id") int id, @RequestParam("almacen") String store) {
        ModelAndView modelAndView = new ModelAndView("administrador/productos/editar");

        modelAndView.addObject("categorias", categoriesService.getCategories());
        modelAndView.addObject("almacenes", storesService.getStores());

        ProductsEntity product = productsService.getProducto(id).orElse(new ProductsEntity());
        InventoriesEntity inventory = inventoriesService.getInventory(id, storesService.getStoreId(store)).orElse(new InventoriesEntity());
        EditProductInventoryForm form = new EditProductInventoryForm(product, inventory);
        modelAndView.addObject("form", form);
        return modelAndView;
    }

    @PostMapping("/inventario/editar")
    public String updateProductInventory(@ModelAttribute EditProductInventoryForm form, @RequestParam("imagen") MultipartFile image) throws IOException {
        byte[] img = image.isEmpty() ? productsService.getProducto(form.product().getIdProducto()).get().getImgProducto() : image.getBytes();
        form.product().setImgProducto(img);
        productsService.saveOrUpdate(form.product());
        inventoriesService.saveOrUpdate(form.inventory());
        return "redirect:/inventario";
    }

    @GetMapping("/inventario/{id}/eliminar")
    public void deleteProductAndInventory(@PathVariable("id") int id) {
        inventoriesService.deleteProduct(id);
    }

}
