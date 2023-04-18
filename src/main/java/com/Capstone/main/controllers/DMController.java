package com.Capstone.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Capstone.main.entities.DM;
import com.Capstone.main.entities.NewDM;
import com.Capstone.main.services.DMService;

@RestController
@RequestMapping("/dm")
@CrossOrigin("http://localhost:4200")

public class DMController {
	@Autowired DMService dmServ;
	
	@PostMapping("/post")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<DM> createDM(@RequestBody NewDM newDm){	
		return new ResponseEntity<DM> (dmServ.saveDM(newDm), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('USER')")
	public void deleteDM(@PathVariable Long id) {
		dmServ.deleteDMById(id);
	}
}
