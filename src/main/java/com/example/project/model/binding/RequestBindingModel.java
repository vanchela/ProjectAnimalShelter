package com.example.project.model.binding;

import com.example.project.model.entities.Animal;
import com.example.project.model.entities.User;
import org.hibernate.validator.constraints.Length;

public class RequestBindingModel {
    private Animal animal;
    private User user;
    private String text;

    public RequestBindingModel() {
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

    @Length(min = 20)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
