package com.Capstone.main.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String body;
	@Column(nullable = false)
	private LocalDateTime creationDate;
	@Column(nullable = false)
	private LocalDateTime lastModifyDate; 
	@Column(nullable = false)
	private int likes;
	private List<String> skills;
	
	public Post(String title, String body, LocalDateTime creationDate, LocalDateTime lastModifyDate, int likes, List<String> skills) {
		super();
		this.title = title;
		this.body = body;
		this.creationDate = creationDate;
		this.lastModifyDate = lastModifyDate;
		this.likes = likes;
		this.skills = skills;
	}
	
	
}
