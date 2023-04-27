package com.Capstone.main.entities;

import java.time.LocalDateTime;
import java.util.List;
import com.Capstone.auth.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Coaching extends Post{
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Coaching(String title, String body, LocalDateTime creationDate, LocalDateTime lastModifyDate, int likes, List<String> skills , User user) {
		super(title, body, creationDate, lastModifyDate, skills);
		
		this.user = user;
		
	}
	
	
}
