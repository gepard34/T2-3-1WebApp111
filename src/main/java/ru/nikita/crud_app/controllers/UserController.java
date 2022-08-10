package ru.nikita.crud_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nikita.crud_app.dao.UserDao;
import ru.nikita.crud_app.model.User;
import ru.nikita.crud_app.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String printTable(Model model) {
        model.addAttribute("usertable", userService.index());
        return "index";
    }

    @GetMapping(value = "/new")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user){
        userService.create(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/{id}/patch")
    public String update(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}/delete/user")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
