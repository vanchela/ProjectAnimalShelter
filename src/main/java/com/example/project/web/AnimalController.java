package com.example.project.web;

import com.example.project.model.binding.AnimalBindingModel;
import com.example.project.model.service.AnimalServiceModel;
import com.example.project.service.AnimalService;
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
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;
    private final ModelMapper modelMapper;

    public AnimalController(AnimalService animalService, ModelMapper modelMapper) {
        this.animalService = animalService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addAnimal(Model model){
        if (!model.containsAttribute("animalBindingModel")){
            model.addAttribute("animalBindingModel",new AnimalBindingModel());
        }
        return "animal-add";
    }

    @PostMapping("/add")
    public String addAnimalConfirm(@Valid AnimalBindingModel animalBindingModel,
                                   BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("animalBindingModel",animalBindingModel);
          redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.animalBindingModel",bindingResult);
            return "redirect:/animals/add";
        }

        animalService.addAnimal(modelMapper.map(animalBindingModel, AnimalServiceModel.class));

        return "redirect:/home";
    }





}
