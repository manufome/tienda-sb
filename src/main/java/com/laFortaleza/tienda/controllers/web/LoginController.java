package com.laFortaleza.tienda.controllers.web;

import com.laFortaleza.tienda.dto.UserDTO;
import com.laFortaleza.tienda.models.UsersEntity;
import com.laFortaleza.tienda.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private UsersService usersService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("newUser", new UserDTO());
        return modelAndView;
    }

    @PostMapping("/login")
    public String login() {
        return "redirect:/";
    }
    @PostMapping("/register")
    public String saveUser(@ModelAttribute UserDTO user) {
        System.out.println("User: " + user);
        if (user.getPassword().equals(user.getConfirmPassword())) {
            return "redirect:/login?" + usersService.saveUser(user);
        }
        String error = "Las contraseñas no coinciden";
        return "redirect:/login?error_register=" + error + "&register_tab=true";
    }

}
