package com.example.project.service.impl;

import com.example.project.model.entities.Role;
import com.example.project.model.enums.RoleEnum;
import com.example.project.repository.RoleRepository;
import com.example.project.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRole() {
       if (roleRepository.count()==0){
           Role admin = new Role(RoleEnum.ADMIN);
           Role user = new Role(RoleEnum.USER);
           roleRepository.save(admin);
           roleRepository.save(user);
       }
    }

    @Override
    public Role findRole(RoleEnum roleEnum) {
        return roleRepository.findByRole(roleEnum);
    }
}
