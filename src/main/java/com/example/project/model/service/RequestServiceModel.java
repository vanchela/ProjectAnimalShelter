package com.example.project.model.service;

import com.example.project.model.entities.Animal;
import com.example.project.model.entities.User;

public class RequestServiceModel {
    private Animal animal;
    private User user;
    private String text;

    public RequestServiceModel() {
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
