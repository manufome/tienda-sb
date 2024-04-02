package com.laFortaleza.tienda.controllers.web;

import com.laFortaleza.tienda.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/cuenta")
    public ModelAndView getUserAccount() {
        ModelAndView modelAndView = new ModelAndView("usuario/cuenta");
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("user", usersService.getUserInfo(currentUserName));
        return modelAndView;
    }


}
