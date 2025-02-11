package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/people")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listAllUsers(Model model) {
        model.addAttribute("people", userService.listAllUsers());
        return "people/index";
    }

    @GetMapping("/show")
    public String getUserById(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "people/show";
    }

    @GetMapping("/saveUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "people/saveUser";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/saveUser";
        }
        userService.addUser(user);
        return "redirect:/people";
    }

    @GetMapping("/edit")
    public String editUserById(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "people/edit";
    }

    @PostMapping("/update")
    public String modifyUserById(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam("id") int id) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }
        userService.modifyUser(id, user);
        return "redirect:/people";
    }

    @PostMapping("/delete")
    public String deleteUserById(@RequestParam("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/people";
    }

}