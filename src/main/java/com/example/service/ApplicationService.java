package com.example.service;

import java.util.List;

import com.example.model.DefaultResponse;
import com.example.model.User;

public interface ApplicationService {
	
	public DefaultResponse register(User user);
	
	public DefaultResponse authenticate(String username, String password);
	
	public List<User> getAllUser();
	
	public DefaultResponse deleteUser(String username);
	
	public String getPopularURL();
	
}
