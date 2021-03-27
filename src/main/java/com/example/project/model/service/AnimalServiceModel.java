package com.example.project.model.service;

import com.example.project.model.entities.AnimalSpecie;
import com.example.project.model.enums.AnimalSpeciesEnum;

public class AnimalServiceModel {
    private String photo;
    private String name;
    private AnimalSpeciesEnum specie;
    private int age;
    private String description;

    public AnimalServiceModel() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalSpeciesEnum getSpecie() {
        return specie;
    }

    public void setSpecie(AnimalSpeciesEnum specie) {
        this.specie = specie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
