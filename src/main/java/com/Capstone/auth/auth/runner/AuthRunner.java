package com.Capstone.auth.auth.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.Capstone.auth.entity.ERole;
import com.Capstone.auth.entity.Role;
import com.Capstone.auth.repository.RoleRepository;


@Component
@Order(value = 1)
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("Run...");
//		setRoleDefault();
		
	}
	
	private void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);
		
		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);
	}
}
