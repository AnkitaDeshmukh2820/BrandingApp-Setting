package com.BA.java.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BA.java.Model.User;
import com.BA.java.Service.UserService;

@RestController
@RequestMapping("/api/account")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<User> updateProfile(
			@RequestBody Long userId,
			@RequestBody String name,
			@RequestBody String email){
		return ResponseEntity.ok(userService.updateProfile(userId, name, email));
	}
	
	@PutMapping("/change-password")
	public ResponseEntity<String>changePassword(
			@RequestParam Long userId,
			@RequestParam String oldPassword,
			@RequestParam String newPassword){
		return ResponseEntity.ok(userService.changePassword(userId, oldPassword, newPassword));
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAccount(@RequestParam Long userId){
		return ResponseEntity.ok(userService.deleteAccount(userId));
	}
}
