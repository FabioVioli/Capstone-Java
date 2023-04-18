package com.Capstone.main.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Capstone.auth.entity.User;
import com.Capstone.main.entities.DM;


public interface DMRepository extends JpaRepository <DM, Long> {

	List<DM> findByReceiver(User user);
}
