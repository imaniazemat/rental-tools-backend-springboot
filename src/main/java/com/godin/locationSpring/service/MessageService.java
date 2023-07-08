package com.godin.locationSpring.service;

import java.security.PublicKey;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godin.locationSpring.model.Message;
import com.godin.locationSpring.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	MessageRepository messageRepository;
	
	public List<Message> getAll(){
		return messageRepository.findAll();
	}
	
	public void insert(Map<String, Object> body) {
		Message message = new Message();
		message.setContenu((String)body.get("contenu"));
		message.setDateEnvoi(new Timestamp(System.currentTimeMillis()));
		message.setExpediteurId((Integer)body.get("expediteurId"));
		message.setRecepteurId((Integer)body.get("recepteurId"));
		
		messageRepository.save(message);
	}

	public List<Message> getByRecepteur(int recepteurId){
//		List<List<Message>> messagesByRecepteurGroupedByExpediteur = new ArrayList<>();
//
//		messageRepository.findByRecepteurId(recepteurId).forEach(x->{
//
//		});
		return messageRepository.findByRecepteurId(recepteurId);
	}

	public List<Message> getByUserId(int userId){
		return messageRepository.findByUserId((userId));
	}

	public List<Integer> getUsersInteracted(int userId){
		return messageRepository.findUsersInteracted(userId);
	}

	public List<Message> getInteractions(int userId1, int userId2){
		return messageRepository.interactions(userId1, userId2);
	}
}
