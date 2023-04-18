package com.Capstone.main.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.Capstone.auth.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@Column(nullable = false)
	@OneToMany
	private List<Reply> replyList = new ArrayList<>();

	public Tutorial(String title, String body, LocalDateTime creationDate, LocalDateTime lastModifyDate, int likes, List<String> skills, User user) {
		super(title, body, creationDate, lastModifyDate, likes, skills);
		this.user = user;
	}
	
	
	

	
}
