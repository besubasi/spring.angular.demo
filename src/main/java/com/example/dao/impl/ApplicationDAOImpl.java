package com.example.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.ApplicationDAO;
import com.example.model.User;
import com.example.util.ApplicationUtil;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {
	
	

	@Override
	public boolean saveUser(User user) {
		ApplicationUtil.createUser(user);		
		return true;
	}	

	@Override
	public User getUserByUserName(String username) {
		return ApplicationUtil.getUserByUserName(username);
	}

	@Override
	public List<User> getAllUser() {
		return ApplicationUtil.getAllUser();
	}

	@Override
	public boolean deleteUser(String username) {
		return ApplicationUtil.deleteUser(username);
	}
	
}
