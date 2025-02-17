package com.BA.java.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BA.java.Model.User;
import com.BA.java.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/account")
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	@PutMapping("/update")
	public ResponseEntity<User> updateProfile(
			@RequestBody User u){
		return ResponseEntity.ok(userService.updateProfile(u));
	}
	
	@PutMapping("/change-password")
	public ResponseEntity<String>changePassword(
			@RequestParam Long id,
			@RequestParam String oldPassword,
			@RequestParam String newPassword){
		return ResponseEntity.ok(userService.changePassword(id, oldPassword, newPassword));
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAccount(@RequestParam Long id){
		return ResponseEntity.ok(userService.deleteAccount(id));
	}
	


	@PostMapping("registerUser")
	public User RegisterUser(@RequestBody User user) {
		System.out.println(user);
		return userService.registerUser(user);
	}
	
	
	
	
}
