package com.Capstone.main.entities;

import java.time.LocalDateTime;
import java.util.List;
import com.Capstone.auth.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tutorials")
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Tutorial extends Post {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	

	public Tutorial(String title, String body, LocalDateTime creationDate, LocalDateTime lastModifyDate, List<String> skills, User user) {
		super(title, body, creationDate, lastModifyDate, skills);
		this.user = user;
	}
	
	
	

	
}
