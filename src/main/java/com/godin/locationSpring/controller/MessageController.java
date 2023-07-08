package com.godin.locationSpring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.godin.locationSpring.model.Message;
import com.godin.locationSpring.service.MessageService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {
	@Autowired
	MessageService messageService;
	
	@GetMapping("/messages")
	public List<Message> getMessages(){
		return messageService.getAll();
	}
	
	@PostMapping("/message/insert")
	public void insertMessage(@RequestBody Map<String, Object> body) {
		messageService.insert(body);
	}

	@GetMapping("/messages/recepteur/{id}")
	public List<Message> getByRecepteur(@PathVariable String id){
		return messageService.getByRecepteur(Integer.valueOf(id));
	}

	@GetMapping("/messages/user/{id}")
	public List<Message> getByUserId(@PathVariable String id){
		return messageService.getByUserId(Integer.valueOf((id)));
	}

	@GetMapping("/messages/usersinteracted/{id}")
	public List<Integer> getUsersInteracted(@PathVariable String id){
		return messageService.getUsersInteracted(Integer.valueOf((id)));
	}

	@GetMapping("/messages/interactions/{id1}/{id2}")
	public List<Message> getInteractions(@PathVariable String id1, @PathVariable String id2){
		return messageService.getInteractions(Integer.valueOf(id1), Integer.valueOf(id2));
	}
}
