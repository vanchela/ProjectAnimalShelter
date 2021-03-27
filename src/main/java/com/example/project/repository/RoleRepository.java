package com.example.project.repository;

import com.example.project.model.entities.Role;
import com.example.project.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRole(RoleEnum role);


}
