package com.Capstone.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Capstone.main.entities.Coaching;

public interface CoachingRepository extends JpaRepository<Coaching, Long>{

	boolean existsById(Long id);
}
