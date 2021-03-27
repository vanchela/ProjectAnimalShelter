package com.example.project.service.impl;

import com.example.project.model.entities.AnimalSpecie;
import com.example.project.model.enums.AnimalSpeciesEnum;
import com.example.project.repository.AnimalSpecieRepository;
import com.example.project.service.AnimalSpecieService;
import org.springframework.stereotype.Service;

@Service
public class AnimalSpecieServiceImpl implements AnimalSpecieService {
    private final AnimalSpecieRepository animalSpecieRepository;

    public AnimalSpecieServiceImpl(AnimalSpecieRepository animalSpecieRepository) {
        this.animalSpecieRepository = animalSpecieRepository;
    }

    @Override
    public AnimalSpecie findBySpecieName(AnimalSpeciesEnum specie) {
        return animalSpecieRepository.findByAnimalSpecie(specie);
    }
}
