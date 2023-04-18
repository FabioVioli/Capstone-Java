package com.Capstone.main.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPost {

	String username;
	List<String> skills;
	String titolo;
	String annuncio;
}
