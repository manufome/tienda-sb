package com.laFortaleza.tienda.controllers.web;

import com.laFortaleza.tienda.models.UsersEntity;
import com.laFortaleza.tienda.services.ProductCategoriesService;
import com.laFortaleza.tienda.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    @Autowired
    private UsersService usersService;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public boolean login() {
//        usersService.login()
        return true;
    }
    @PostMapping("/register")
    public UsersEntity saveUser(@RequestBody UsersEntity user) {

        String password = user.getPassword();
        String newPassword = passwordEncoder.encode(password);
        user.setPassword(newPassword);
        return usersService.saveOrUpdate(user);
    }
}
