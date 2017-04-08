package com.example.dao;

import java.util.List;

import com.example.model.DefaultResponse;
import com.example.model.User;

public interface ApplicationDAO {
	
	public boolean saveUser(User user);

	public User getUserByUserName(String username);
	
	public List<User> getAllUser();
	
	public boolean deleteUser(String username);
	

}
