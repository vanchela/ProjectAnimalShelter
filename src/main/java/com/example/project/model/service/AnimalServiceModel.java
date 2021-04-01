package com.example.project.model.service;

import com.example.project.model.enums.AnimalSpeciesEnum;
import org.springframework.web.multipart.MultipartFile;

public class AnimalServiceModel {
    private Long id;
    private MultipartFile photo;
    private String name;
    private AnimalSpeciesEnum specie;
    private int age;
    private String description;

    public AnimalServiceModel() {
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
