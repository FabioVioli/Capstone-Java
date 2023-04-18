package com.Capstone.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Capstone.main.entities.Reply;
import com.Capstone.main.services.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Autowired ReplyService replyServ;
	
	@GetMapping
	public ResponseEntity<List<Reply>> getAllReplies(){
		return new ResponseEntity<List<Reply>>(replyServ.getAllReplies(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reply> getReplyById(@PathVariable Long id){
		return new ResponseEntity<Reply>(replyServ.getReplyById(id), HttpStatus.OK);
	}
	
	@PostMapping("/post")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Reply> createReply(@RequestBody Reply reply){
		return new ResponseEntity<Reply> (replyServ.saveReply(reply), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Reply> updateReply(@RequestBody Reply reply){
		return new ResponseEntity<Reply> (replyServ.updateReply(reply), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('USER')")
	public String deleteReply(@PathVariable long id){
		replyServ.deleteReplyById(id);
		return "Annuncio cancellato!";
	} 
	
	//--------------------------------------------------------------------------
	
	@GetMapping("/list/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Reply>> getAllRepliesByTutorial(@PathVariable Long id){
		return new ResponseEntity<List<Reply>>(replyServ.getAllReplyByTutorial(id), HttpStatus.OK);
	}
}
