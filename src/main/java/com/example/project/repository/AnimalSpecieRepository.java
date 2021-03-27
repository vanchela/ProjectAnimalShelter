package com.example.project.repository;

import com.example.project.model.entities.AnimalSpecie;
import com.example.project.model.enums.AnimalSpeciesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalSpecieRepository extends JpaRepository<AnimalSpecie,Long> {
    AnimalSpecie findByAnimalSpecie(AnimalSpeciesEnum specie);
}
