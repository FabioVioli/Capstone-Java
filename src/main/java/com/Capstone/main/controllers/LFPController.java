package com.Capstone.main.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Capstone.auth.entity.User;
import com.Capstone.auth.repository.UserRepository;
import com.Capstone.main.entities.LFP;
import com.Capstone.main.entities.NewPost;
import com.Capstone.main.services.LFPService;

@RestController
@RequestMapping("/lfp")
@CrossOrigin("http://localhost:4200")
public class LFPController {

	@Autowired LFPService LFPServ;
	@Autowired UserRepository userRepo;
	
	@GetMapping()
	public ResponseEntity<List<LFP>> getAllLFP(){
		return new ResponseEntity<List<LFP>>(LFPServ.getAllLFP(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LFP> getLFPById(@PathVariable Long id){
		return new ResponseEntity<LFP>(LFPServ.getLFPById(id), HttpStatus.OK);
	}
	
	@PostMapping("/post")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<LFP> createLFP(@RequestBody NewPost newPost){
		String username = newPost.getUsername();
		User user = userRepo.findByUsername(username);
		return new ResponseEntity<LFP> (LFPServ.saveLFP(user, newPost.getTitolo(), newPost.getSkills(), newPost.getAnnuncio()), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<LFP> updateLFP(@RequestBody LFP lfp){
		return new ResponseEntity<LFP> (LFPServ.updateLFP(lfp), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('USER')")
	public void deleteTutorial(@PathVariable long id){
		LFPServ.deleteLFPById(id);
		
	}
	
	// POPULATION
	
	@PostMapping("/postman")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<LFP> createLFP(@RequestBody LFP lfp){
		return new ResponseEntity<LFP> (LFPServ.saveLFPostman(lfp), HttpStatus.OK);
	}
}
