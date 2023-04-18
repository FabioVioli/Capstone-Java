package com.Capstone.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Capstone.main.entities.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
