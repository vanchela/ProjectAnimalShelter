package com.example.project.service.impl;

import com.example.project.model.entities.Animal;
import com.example.project.model.service.AnimalServiceModel;
import com.example.project.repository.AnimalRepository;
import com.example.project.service.AnimalService;
import com.example.project.service.AnimalSpecieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final ModelMapper modelMapper;
    private final AnimalSpecieService animalSpecieService;

    public AnimalServiceImpl(AnimalRepository animalRepository, ModelMapper modelMapper, AnimalSpecieService animalSpecieService) {
        this.animalRepository = animalRepository;
        this.modelMapper = modelMapper;
        this.animalSpecieService = animalSpecieService;
    }


    @Override
    public void addAnimal(AnimalServiceModel animalServiceModel) {
        Animal animal = modelMapper.map(animalServiceModel,Animal.class);
        animal.setSpecie(animalSpecieService.findBySpecieName(animalServiceModel.getSpecie()));
        animalRepository.save(animal);
    }
}
