package com.example.project.service;

import com.example.project.model.entities.AnimalSpecie;
import com.example.project.model.enums.AnimalSpeciesEnum;

public interface AnimalSpecieService {
    AnimalSpecie findBySpecieName(AnimalSpeciesEnum specie);
}
