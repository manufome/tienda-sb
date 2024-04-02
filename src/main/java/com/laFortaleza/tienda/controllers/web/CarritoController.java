package com.laFortaleza.tienda.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarritoController {

    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

}
