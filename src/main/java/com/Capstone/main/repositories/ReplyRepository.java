package com.Capstone.main.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Capstone.main.entities.Reply;
import com.Capstone.main.entities.Tutorial;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
	
	List<Reply> findByTutorial(Tutorial t);
	
}
