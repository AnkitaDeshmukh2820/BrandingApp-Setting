package com.BA.java.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	private String name;
	private String password;
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void setName(String name2) {
		// TODO Auto-generated method stub
		
	}
	public static void setEmail(String email2) {
		// TODO Auto-generated method stub
		
	}
	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}
	

}
