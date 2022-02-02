package com.brightrace.SpringbootRestApiTalkWS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.brightrace.SpringbootRestApiTalkWS.services.*;
import com.brightrace.SpringbootRestApiTalkWS.model.*;
@RestController
public class TalkController {
	@Autowired
	private TalkService talkservice;
	@GetMapping("/talks")
	public List<Talk> getTalks()
	{
		return talkservice.getTalks();
	}
	@GetMapping("/talks/{id}")
	public ResponseEntity<Talk> getTalk(@PathVariable int id) {
	    try {
	        Talk talk = talkservice.getTalk(id);
	        return new ResponseEntity<Talk>(talk, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Talk>(HttpStatus.NOT_FOUND);
	    }      
	}
	@PostMapping("/talks")
	public void insert(@RequestBody Talk talk) {
		talkservice.save(talk);
	}
	@DeleteMapping("/talks/{id}")
	public void delete(@PathVariable Integer id) {
		talkservice.delete(id);
	}
	@PutMapping("/talks/{id}")
	public ResponseEntity<?> update(@RequestBody Talk talk, @PathVariable Integer id){
		try {
			talk.setId(id);
			
			talkservice.save(talk);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
