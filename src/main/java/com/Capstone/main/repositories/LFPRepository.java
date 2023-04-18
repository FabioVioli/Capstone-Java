package com.Capstone.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capstone.auth.entity.User;
import com.Capstone.main.entities.LFP;

public interface LFPRepository extends JpaRepository<LFP, Long> {

	List<LFP> findByUser(User user);
	
	boolean existsById(Long id);
}
