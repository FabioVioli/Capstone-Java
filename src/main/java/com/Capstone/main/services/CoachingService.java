package com.Capstone.main.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Capstone.auth.entity.User;
import com.Capstone.main.entities.Coaching;
import com.Capstone.main.repositories.CoachingRepository;


@Service

public class CoachingService {

	@Autowired CoachingRepository repo;
	
	public Coaching saveCoaching(User user, String titolo, List<String> skills, String annuncio) {
		Coaching coaching = new Coaching(titolo, annuncio, LocalDateTime.now(), LocalDateTime.now(), 0, skills, user);
		return repo.save(coaching);
	}
	
	public Coaching getCoachingById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Coaching> getAllCoaching(){
		return repo.findAll();
	}
	
	public Coaching updateCoaching(Coaching c) {
		c.setLastModifyDate(LocalDateTime.now());
		return repo.save(c);
	} 
	
	public String deleteCoachingById(Long id) {
		repo.deleteById(id);
		return "Annuncio Cancellato!";
	}
}
