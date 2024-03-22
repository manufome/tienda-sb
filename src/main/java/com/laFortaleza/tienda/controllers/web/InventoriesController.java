package com.laFortaleza.tienda.controllers.web;

import com.laFortaleza.tienda.services.InventoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InventoriesController {
    @Autowired
    private InventoriesService inventoriesService;

    @GetMapping("/inventarios")
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView("administrador/inventarios");
        modelAndView.addObject("products", inventoriesService.getProducts());
        return modelAndView;
    }

}
