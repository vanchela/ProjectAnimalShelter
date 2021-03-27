package com.example.project.model.binding;

import com.example.project.model.entities.AnimalSpecie;
import com.example.project.model.enums.AnimalSpeciesEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AnimalBindingModel {
    private String photo;
    private String name;
    private AnimalSpeciesEnum specie;
    private int age;
    private String description;

    public AnimalBindingModel() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Size(min = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public AnimalSpeciesEnum getSpecie() {
        return specie;
    }

    public void setSpecie(AnimalSpeciesEnum specie) {
        this.specie = specie;
    }

    @Min(value = 0)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Size(min = 10)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
