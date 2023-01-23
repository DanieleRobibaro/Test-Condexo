package com.condexo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condexo.model.User;
import com.condexo.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		if(!userRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
		return userRepository.findById(id).get();
	}
	
	public User postUser(User user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			throw new EntityNotFoundException("User existing yet");
		}
		return userRepository.save(user);
	}
	
	public User putUser(Long id, User user) {
		if (!userRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found");
		}
		
		User u = userRepository.findById(id).get();
		u.setUsername(user.getUsername());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		
		return userRepository.save(u);
		}

}
