package com.Capstone.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Capstone.auth.entity.User;
import com.Capstone.auth.repository.UserRepository;
import com.Capstone.main.entities.DM;
import com.Capstone.main.entities.LFP;
import com.Capstone.main.repositories.DMRepository;
import com.Capstone.main.repositories.LFPRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {
	
	@Autowired UserRepository userRepo;
	@Autowired LFPRepository LFPRepo;
	@Autowired DMRepository DMRepo;
	
	@GetMapping("/data/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username){
		return new ResponseEntity<User>(userRepo.findByUsername(username), HttpStatus.OK);
	}
	
	@GetMapping("/lfp/{username}")
	public ResponseEntity<List<LFP>> getAllUserLFP(@PathVariable String username){
		User user = userRepo.findByUsername(username);
		return new ResponseEntity<List<LFP>>(LFPRepo.findByUser(user), HttpStatus.OK);
	}
	
	@GetMapping("/dm/{username}")
	public ResponseEntity<List<DM>> getAllUserDM(@PathVariable String username){
		User user = userRepo.findByUsername(username);
		return new ResponseEntity<List<DM>>(DMRepo.findByReceiver(user), HttpStatus.OK);
	}
}
