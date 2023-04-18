package com.Capstone.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capstone.auth.entity.ERole;
import com.Capstone.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
