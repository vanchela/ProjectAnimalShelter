package com.example.project.web;

import com.example.project.model.enums.RoleEnum;
import com.example.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/roles")
public class RolesController {
    private final UserService userService;

    public RolesController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/add")
    public String changeRole(Model model){
        model.addAttribute("names", userService.findAllUsernames());
        return "role-add";
    }

    @PostMapping("/add")
    public String changeRoleConfirm(@RequestParam String username, @RequestParam String role){
        userService.addRole(username,RoleEnum.valueOf(role.toUpperCase()));

        return "redirect:/home";
    }
}
