package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void save(User data) {
		userRepository.save(data);
	}
	
	public List<User> findAllData() {
		return  userRepository.findAll();
	  
	}
	
	public boolean login(User data) {
		User nameFound=userRepository.findByName(data.getName());
		User locationFound=userRepository.findByLocation(data.getLocation());
		 boolean isUserFound=false;
		
		if(nameFound!=null && locationFound!=null) {
			isUserFound=true;
		}
		return isUserFound;
	}
}
