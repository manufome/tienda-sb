package com.laFortaleza.tienda.controllers.web;

import com.laFortaleza.tienda.services.ProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
    @Autowired
    private ProductCategoriesService productCategoriesService;

    @GetMapping(value={ "/", "home"})
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("categories", productCategoriesService.getCategories());
        return modelAndView;
    }
}
