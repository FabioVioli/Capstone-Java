package com.Capstone.main.runners;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import com.Capstone.auth.entity.User;
import com.Capstone.main.entities.Coaching;
import com.Capstone.main.entities.LFP;
import com.Capstone.main.entities.Reply;
import com.Capstone.main.entities.Tutorial;
import com.Capstone.main.services.CoachingService;
import com.Capstone.main.services.LFPService;
import com.Capstone.main.services.ReplyService;
import com.Capstone.main.services.TutorialService;
import com.Capstone.main.services.UserService;

@Controller
@Order(value = 2)
public class MainRunner implements ApplicationRunner {

	@Autowired UserService userServ;
	@Autowired TutorialService tutorialServ;
	@Autowired LFPService LFPServ;
	@Autowired CoachingService coachingServ;
	@Autowired ReplyService replyServ;
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("MainRunner is running...");
		
//		User u = userServ.getUserById(1L);
//		System.out.println(u);
//		
//		Tutorial t = new Tutorial("Titolo Tutorial", "Testo", Date.valueOf("2023-01-05"), Date.valueOf("2023-02-20"), 0, u);
//		tutorialServ.saveTutorial(t);
		
//		LFP l = new LFP("Titolo LFP", "Testo", Date.valueOf("2023-01-05"), Date.valueOf("2023-02-20"), 0, u);
//		LFPServ.saveLFP(l);
		
//		Coaching c = new Coaching("Titolo Coaching", "Testo", Date.valueOf("2023-01-05"), Date.valueOf("2023-02-20"), 0, u);
//		coachingServ.saveCoaching(c);
		
//		Tutorial t1 = tutorialServ.getTutorialById(802L);
//		Reply r = new Reply("new reply!", "Testo", Date.valueOf("2023-01-05"), Date.valueOf("2023-02-20"), 0, t1, u);
//		replyServ.saveReply(r);
		
		
	}

}
