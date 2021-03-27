package com.example.project.service;

import com.example.project.model.entities.Role;
import com.example.project.model.entities.User;
import com.example.project.model.enums.RoleEnum;
import com.example.project.model.service.UserRegistrationServiceModel;

import java.util.List;

public interface UserService {


    boolean usernameExists(String username);

    void registerAndLoginUser(UserRegistrationServiceModel userServiceModel);

    List<String> findAllUsernames();


    void addRole(String username, RoleEnum valueOf);
}
