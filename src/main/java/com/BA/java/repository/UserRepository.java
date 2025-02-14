package com.BA.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BA.java.Model.User;



public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

}
