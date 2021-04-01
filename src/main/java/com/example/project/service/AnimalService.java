package com.example.project.service;

import com.example.project.model.service.AnimalServiceModel;
import com.example.project.model.view.AnimalViewModel;

import java.util.List;

public interface AnimalService {


    void addAnimal(AnimalServiceModel animalServiceModel);


    List<AnimalViewModel> findAllAnimals();

    AnimalViewModel findById(Long id);
}
