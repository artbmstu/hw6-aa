package ru.artbmstu.hw6aa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.artbmstu.hw6aa.model.User;
import ru.artbmstu.hw6aa.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public ModelAndView user(@PathVariable(name = "id") String id){
        return new ModelAndView("user", "user", userService.getUserById(id));
    }

    @PostMapping("saveUser")
    public ModelAndView saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return new ModelAndView("redirect:/" + user.getId());
    }
}
