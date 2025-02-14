package com.BA.java.Service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BA.java.Model.User;
import com.BA.java.repository.UserRepository;

@Service
public class UserService {
	
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository= userRepository;
		this.passwordEncoder= passwordEncoder;
	}
	
	public User updateProfile(Long userId, String name, String email) {
		Optional<User> optionalUser =userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			User.setName(name);
			User.setEmail(email);
			return userRepository.save(user);
		}
		throw new RuntimeException("User not found");
	}

	public String changePassword(Long userId, String oldPassword, String newPassword) {
		Optional<User> optionalUser =userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			User user =optionalUser.get();
			if(passwordEncoder.matches(oldPassword, user.getPassword())) {
				user.setPassword(passwordEncoder.encode(newPassword));
				userRepository.save(user);
				return "Password changed successfully";
				
			}else {
				return "Old password is incorrect";
			}
			
	}
			throw new RuntimeException("User not found");
		}
		 public  String deleteAccount(Long userId) {
			 if(userRepository.existsById(userId)) {
				 userRepository.deleteById(userId);
				 return "Account deleted succefully";
			 }
			 throw new RuntimeException("User not found");
		 }
	
}
