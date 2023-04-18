package com.Capstone.main.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.auth.entity.User;
import com.Capstone.auth.repository.UserRepository;
import com.Capstone.main.entities.Coaching;
import com.Capstone.main.entities.DM;
import com.Capstone.main.entities.LFP;
import com.Capstone.main.entities.NewDM;
import com.Capstone.main.repositories.CoachingRepository;
import com.Capstone.main.repositories.DMRepository;
import com.Capstone.main.repositories.LFPRepository;
@Service
public class DMService {
@Autowired DMRepository repo;
@Autowired UserRepository userRepo;
@Autowired LFPRepository lfpRepo;
@Autowired CoachingRepository coachingRepo;
@Autowired UserService userServ;
@Autowired LFPService lfpServ;
@Autowired CoachingService coachingServ;
	
	public DM saveDM(NewDM newDm) {
		User sender = userRepo.findByUsername(newDm.getSender());
		Long postId = newDm.getReceiverId();
		if(lfpRepo.existsById(postId)) {
			LFP lfp = lfpServ.getLFPById(postId);
			User receiver = lfp.getUser();
			String text = newDm.getBody();
			DM dm = new DM(sender, receiver, text);
			return repo.save(dm);
		}else if(coachingRepo.existsById(postId)) {
			Coaching coaching = coachingServ.getCoachingById(postId);
			User receiver = coaching.getUser();
			String text = newDm.getBody();
			DM dm = new DM(sender, receiver, text);
			return repo.save(dm);
		}else {
			return null;
		}
	}
	
	public DM getDMById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<DM> getAllDM(){
		return repo.findAll();
	}
	
	public DM updateDM(DM dm) {
		return repo.save(dm);
	} 
	
	public String deleteDMById(Long id) {
		repo.deleteById(id);
		return "Annuncio Cancellato!";
	}
	

}
