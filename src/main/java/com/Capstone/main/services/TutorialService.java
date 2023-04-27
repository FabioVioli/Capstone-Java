package com.Capstone.main.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Capstone.auth.entity.User;
import com.Capstone.main.entities.Tutorial;
import com.Capstone.main.repositories.TutorialRepository;

@Service

public class TutorialService {

	@Autowired TutorialRepository repo;
	
	public Tutorial saveTutorial(User user, String titolo, List<String> skills, String annuncio) {
		Tutorial tutorial = new Tutorial(titolo, annuncio, LocalDateTime.now(), LocalDateTime.now(), skills, user);
		return repo.save(tutorial);
	}
	
	public Tutorial getTutorialById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Tutorial> getAllTutorial(){
		return repo.findAll();
	}
	
	public Tutorial updateTutorial(Tutorial t) {
		t.setLastModifyDate(LocalDateTime.now());
		return repo.save(t);
	} 
	
	public String deleteTutorialById(Long id) {
		repo.deleteById(id);
		return "Tutorial Cancellato!";
	}
}
