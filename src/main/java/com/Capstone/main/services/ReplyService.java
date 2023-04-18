package com.Capstone.main.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Capstone.main.entities.Reply;
import com.Capstone.main.entities.Tutorial;
import com.Capstone.main.repositories.ReplyRepository;

@Service
public class ReplyService {

	@Autowired ReplyRepository repo;
	@Autowired TutorialService tutorialRepo;
	
	public Reply saveReply(Reply r) {
		return repo.save(r);
	}
	
	public Reply getReplyById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Reply> getAllReplies(){
		return repo.findAll();
	}
	
	public Reply updateReply(Reply r) {
		return repo.save(r);
	} 
	
	public String deleteReplyById(Long id) {
		repo.deleteById(id);
		return "Reply Cancellato!";
	}
	
	// -----------------------------------
	
	public List<Reply> getAllReplyByTutorial(Long id){
		Tutorial t = tutorialRepo.getTutorialById(id);
		return repo.findByTutorial(t);
	}
	
}
