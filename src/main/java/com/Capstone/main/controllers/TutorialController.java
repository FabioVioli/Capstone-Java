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
import com.Capstone.main.entities.NewPost;
import com.Capstone.main.entities.Tutorial;
import com.Capstone.main.services.TutorialService;

@RestController
@RequestMapping("/tutorials")
@CrossOrigin("http://localhost:4200")
public class TutorialController {

	@Autowired TutorialService tutorialServ;
	@Autowired UserRepository userRepo;
	
	@GetMapping
	public ResponseEntity<List<Tutorial>> getAllTutorials(){
		return new ResponseEntity<List<Tutorial>>(tutorialServ.getAllTutorial(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tutorial> getTutorialById(@PathVariable Long id){
		return new ResponseEntity<Tutorial>(tutorialServ.getTutorialById(id), HttpStatus.OK);
	}
	
	@PostMapping("/post")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Tutorial> createTutorial(@RequestBody NewPost newPost){
		String username = newPost.getUsername();
		User user = userRepo.findByUsername(username);
		return new ResponseEntity<Tutorial> (tutorialServ.saveTutorial(user, newPost.getTitolo(), newPost.getSkills(), newPost.getAnnuncio()), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Tutorial> updateTutorial(@RequestBody Tutorial tutorial){
		return new ResponseEntity<Tutorial> (tutorialServ.updateTutorial(tutorial), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('USER')")
	public void deleteTutorial(@PathVariable long id){
		tutorialServ.deleteTutorialById(id);
		
	}
}
