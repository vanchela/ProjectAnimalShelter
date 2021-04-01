package com.example.project.web;

import com.example.project.model.binding.AnimalBindingModel;
import com.example.project.model.binding.RequestBindingModel;
import com.example.project.model.service.RequestServiceModel;
import com.example.project.service.AnimalService;
import com.example.project.service.FormResqueService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/allAnimals")
public class AllAnimalsController {
    private final AnimalService animalService;
    private final ModelMapper modelMapper;
    private final FormResqueService formResqueService;


    public AllAnimalsController(AnimalService animalService, ModelMapper modelMapper, FormResqueService formResqueService) {
        this.animalService = animalService;
        this.modelMapper = modelMapper;
        this.formResqueService = formResqueService;
    }

    @GetMapping("/all")
    public ModelAndView all(ModelAndView modelAndView){
        modelAndView.addObject("animals", animalService.findAllAnimals());
        modelAndView.setViewName("animals-all");
        return modelAndView;
    }

    @GetMapping("/adopt")
    public ModelAndView adopt(@RequestParam("id") Long id, ModelAndView modelAndView, Model model){
        if (!model.containsAttribute("requestBindingModel")){
            model.addAttribute("requestBindingModel",new RequestBindingModel());
        }
        modelAndView.addObject("animalAdopt", this.animalService.findById(id));
        modelAndView.setViewName("animal-adopt");
        return modelAndView;
    }

    @PostMapping("/adopt")
    public String adoptConfirm(@Valid RequestBindingModel requestBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("requestBindingModel",requestBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.requestBindingModel",bindingResult);
            return "redirect:/allAnimals/adopt";
        }

        RequestServiceModel requestServiceModel = modelMapper.map(requestBindingModel,RequestServiceModel.class);

        formResqueService.fillForm(requestServiceModel);


        return "redirect:/home";
    }

}
