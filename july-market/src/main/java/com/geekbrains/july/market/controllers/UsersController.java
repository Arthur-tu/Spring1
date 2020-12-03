package com.geekbrains.july.market.controllers;

import com.geekbrains.july.market.entities.dtos.UserDto;
import com.geekbrains.july.market.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info/{id}")
    public String getUserInfo(@PathVariable Long id, Model model) {
        UserDto userDto = userService.getDtoDataById(id);
        model.addAttribute("user", userDto);
        return "user_info";
    }
}
