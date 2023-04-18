package com.Capstone.main.entities;

import java.sql.Date;

import com.Capstone.auth.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "replies")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String body;
	@Column(nullable = false)
	private Date creationDate;
	@Column(nullable = false)
	private Date lastModifyDate; 
	@Column(nullable = false)
	private int likes;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Tutorial tutorial;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Reply(String title, String body, Date creationDate, Date lastModifyDate, int likes, Tutorial tutorial, User user) {
		this.title = title;
		this.body = body;
		this.creationDate = creationDate;
		this.lastModifyDate = lastModifyDate;
		this.tutorial = tutorial;
		this.user = user;
	}

	public Reply(Long id, String title, String body, Date creationDate, Date lastModifyDate, int likes, Tutorial tutorial,
			User user) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.creationDate = creationDate;
		this.lastModifyDate = lastModifyDate;
		this.likes = likes;
		this.tutorial = tutorial;
		this.user = user;
	}
	
	
	
	

}
