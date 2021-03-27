package com.example.project.service;

import com.example.project.model.entities.Role;
import com.example.project.model.enums.RoleEnum;

public interface RoleService {

    void initRole();

    Role findRole(RoleEnum roleEnum);
}
