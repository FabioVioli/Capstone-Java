package com.Capstone.main.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Capstone.auth.entity.User;
import com.Capstone.main.entities.LFP;
import com.Capstone.main.repositories.LFPRepository;

@Service
public class LFPService {

	@Autowired LFPRepository repo;
	
	public LFP saveLFP(User user, String titolo, List<String> skills, String annuncio) {
		LFP lfp = new LFP(titolo, annuncio, LocalDateTime.now(), LocalDateTime.now(), 0, skills, user);
		return repo.save(lfp);
	}
	
	public LFP getLFPById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<LFP> getAllLFP(){
		return repo.findAll();
	}
	
	public LFP updateLFP(LFP lfp) {
		lfp.setLastModifyDate(LocalDateTime.now());
		return repo.save(lfp);
	} 
	
	public String deleteLFPById(Long id) {
		repo.deleteById(id);
		return "Annuncio Cancellato!";
	}
	
	
	// XXXXXXXXXXXXXXXXXX
	
	public LFP saveLFPostman(LFP lfp) {
		return repo.save(lfp);
	}
}

