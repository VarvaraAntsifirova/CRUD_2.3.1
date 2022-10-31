package org.example.CRUD.controllers;

import org.example.CRUD.Services.UserService;
import org.example.CRUD.dao.UserDao;
import org.example.CRUD.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.example.CRUD.Services.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    public final UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "views/users";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        service.createUser(user.getFirstName(), user.getLastName(), user.getAge());
        return "views/new";
    }

    @PostMapping("/edit")
    public String editUser() {

        return "views/edit";
    }
}
