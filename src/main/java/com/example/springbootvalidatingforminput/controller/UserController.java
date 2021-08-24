package com.example.springbootvalidatingforminput.controller;


import com.example.springbootvalidatingforminput.model.User;
import com.example.springbootvalidatingforminput.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String getUserList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "userList";
    }

    @GetMapping("create")
    public String createUserForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("action", "create");
        return "userForm";
    }
    @PostMapping("create")
    public String postUser(Model model, @ModelAttribute @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("action", "create");
            return "userForm";
        }
        userService.insertByUser(user);
        return "redirect:/users/";
    }

    @GetMapping  ("update/{id}")
    public String getUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("action" , "update");
        return "userForm";
    }

    @PostMapping("update")
    public String putUser(Model model, @ModelAttribute @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("action", "update");
            return "userForm";
        }
        userService.update(user);
        return "redirect:/users/";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/users/";
    }
}


































