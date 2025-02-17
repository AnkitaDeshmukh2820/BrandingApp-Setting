package com.BA.java.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.BA.java.Model.User;
import com.BA.java.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private final UserRepository userRepository;
	

//	@Autowired
//	PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	public User updateProfile(User u) {
//		Optional<User> optionalUser = userRepository.findById(u.getId());
			return userRepository.save(u);
	
	}

	public String changePassword(Long id, String oldPassword, String newPassword) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			if(oldPassword.equals(user.getPass())){
			user.setPass(newPassword);
			userRepository.save(user);
				return "Password changed successfully";
				
			}else {
				return "Old password is incorrect";
			}

	}
		throw new RuntimeException("User not found");
	}

	public String deleteAccount(Long id) {
	userRepository.deleteById(id);
	return "user deleted succcessfully";
	}

	public User registerUser(User user) {
        // Ensure role is USER
        // Encode password before saving
        return userRepository.save(user);
    }

	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

}
