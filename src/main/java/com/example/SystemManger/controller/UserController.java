package com.example.SystemManger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SystemManger.entity.User;
import com.example.SystemManger.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
    public String usersPage(Model model) {
        model.addAttribute("userlist",userService.getALlUsers());
        return "viewusers";
    }
	
	@GetMapping("/adduser")
    public String showUserRegForm(Model model) {
        User user= new User();
        model.addAttribute("user",user);
        return "adduser";
    }
	
	@PostMapping("/registeruser")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }
}
