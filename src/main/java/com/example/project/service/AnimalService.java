package com.example.project.service;

import com.example.project.model.entities.Animal;
import com.example.project.model.service.AnimalServiceModel;
import com.example.project.model.view.AnimalViewModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AnimalService {


    void addAnimal(AnimalServiceModel animalServiceModel) throws SQLException, IOException;


    List<AnimalViewModel> findAllAnimals();

    AnimalViewModel findById(Long id);

    Animal getAnimal(Animal animal);
}
