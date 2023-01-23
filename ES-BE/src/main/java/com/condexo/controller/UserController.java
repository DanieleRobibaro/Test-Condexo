package com.condexo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condexo.model.User;
import com.condexo.services.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> postUser(@RequestBody User user){
		
		return ResponseEntity.ok(userService.postUser(user));
	}
	
	@PutMapping("/change/{id}")
	public ResponseEntity<User> putUser(@PathVariable Long id,@RequestBody  User user){
		
		return ResponseEntity.ok(userService.putUser(id, user));
	}
}
