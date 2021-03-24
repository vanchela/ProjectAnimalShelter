package com.example.project.web;

import com.example.project.model.binding.UserRegistrationBindingModel;
import com.example.project.model.service.UserRegistrationServiceModel;
import com.example.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @ModelAttribute("userRegistrationBindingModel")
    public UserRegistrationBindingModel createBindingModel() {
        return new UserRegistrationBindingModel();
    }


    @GetMapping("/login")
   public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registrationAndLogin(@Valid UserRegistrationBindingModel userRegistrationBindingModel,
                                       BindingResult bindingResult,RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegistrationBindingModel",userRegistrationBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationBindingModel",bindingResult);
            return "redirect:/users/register";
        }

        if (userService.usernameExists(userRegistrationBindingModel.getUsername())){
            redirectAttributes.addFlashAttribute("userRegistrationBindingModel",userRegistrationBindingModel);
            redirectAttributes.addFlashAttribute("userExistsError",true);
            return "redirect:/users/register";
        }

        UserRegistrationServiceModel userServiceModel = modelMapper.map(userRegistrationBindingModel,UserRegistrationServiceModel.class);

        userService.registerAndLoginUser(userServiceModel);

        return "redirect:/home";
    }

    @PostMapping("/notSuccessfulLogin")
    public String failedLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                                      String username,
                              RedirectAttributes attributes) {

        attributes.addFlashAttribute("not_ok_credentials", true);
        attributes.addFlashAttribute("username", username);

        return "redirect:/users/login";
    }


}
