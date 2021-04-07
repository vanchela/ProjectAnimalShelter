package com.example.project.service.impl;

import com.example.project.model.entities.FormResqueAnimal;
import com.example.project.model.entities.User;
import com.example.project.model.service.RequestServiceModel;
import com.example.project.repository.FormResqueAnimalRepository;
import com.example.project.service.AnimalService;
import com.example.project.service.FormResqueService;
import com.example.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class FormResqueServiceImpl implements FormResqueService {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final AnimalService animalService;
    private final FormResqueAnimalRepository formResqueAnimalRepository;

    public FormResqueServiceImpl(ModelMapper modelMapper, UserService userService, AnimalService animalService, FormResqueAnimalRepository formResqueAnimalRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.animalService = animalService;
        this.formResqueAnimalRepository = formResqueAnimalRepository;
    }

    @Override
    public void fillForm(RequestServiceModel requestServiceModel) {
        FormResqueAnimal formResqueAnimal = modelMapper.map(requestServiceModel, FormResqueAnimal.class);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userService.getUser(userDetails.getUsername());
        formResqueAnimal.setAnimal(animalService.getAnimal(requestServiceModel.getAnimal()));
        formResqueAnimal.setUser(user);
        formResqueAnimalRepository.save(formResqueAnimal);
    }
}
