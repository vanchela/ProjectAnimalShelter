package com.example.project.service.impl;
import com.example.project.model.entities.Role;
import com.example.project.model.entities.User;
import com.example.project.model.enums.RoleEnum;
import com.example.project.model.service.UserRegistrationServiceModel;
import com.example.project.repository.RoleRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.RoleService;
import com.example.project.service.UserService;


import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AnimalUserService animalUserService;
    private final RoleService roleService;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository, AnimalUserService animalUserService, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.animalUserService = animalUserService;
        this.roleService = roleService;

    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userServiceModel) {
        User newUser = modelMapper.map(userServiceModel,User.class);
        newUser.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        Role userRole = roleRepository.findByRole(RoleEnum.USER);


        newUser.addRole(userRole);
        newUser = userRepository.save(newUser);

        UserDetails principal = animalUserService.loadUserByUsername(newUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public List<String> findAllUsernames() {
        return userRepository.findAllUsernames();
    }

    @Override
    public void addRole(String username, RoleEnum roleEnum) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null){
            if (!user.getRoles().contains(roleRepository.findByRole(roleEnum))){
              user.addRole(roleRepository.findByRole(roleEnum));
              userRepository.save(user);
            }
        }


    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }


}
