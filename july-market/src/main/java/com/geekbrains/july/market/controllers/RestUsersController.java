package com.geekbrains.july.market.controllers;

import com.geekbrains.july.market.entities.User;
import com.geekbrains.july.market.exceptions.UserNotFoundException;
import com.geekbrains.july.market.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class RestUsersController {
    private UserService userService;

    @Autowired
    public RestUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        if (!userService.existsById(id)) {
            throw new UserNotFoundException("User not found, id: " + id);
        }
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/info/{id}")
    public String getUserInfo(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user_info";
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(UserNotFoundException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }
}
