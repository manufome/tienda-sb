package com.laFortaleza.tienda.controllers.web;
import com.laFortaleza.tienda.services.ProductCategoriesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.laFortaleza.tienda.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private ProductCategoriesService productCategoriesService;

    @GetMapping("/productos")
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView("producto/productos");
        modelAndView.addObject("products", productsService.getProductos());
        modelAndView.addObject("categories", productCategoriesService.getCategories());
        return modelAndView;
    }
}