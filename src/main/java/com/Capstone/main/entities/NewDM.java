package com.Capstone.main.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewDM {

	private String sender;
	private Long receiverId;
	private String body;
}
