package com.Capstone.main.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Capstone.auth.entity.User;
import com.Capstone.auth.repository.UserRepository;


@Service
public class UserService  {

	@Autowired UserRepository repo;
	
	public User saveUser(User u) {
		return repo.save(u);
	}
	
	public User getUserById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<User> getAllUser(){
		return repo.findAll();
	}
	
	public User updateUser(User u) {
		return repo.save(u);
	} 
	
	public String deleteUserById(Long id) {
		repo.deleteById(id);
		return "User Cancellato!";
	}
	
}

