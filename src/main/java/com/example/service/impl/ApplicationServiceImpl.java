package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ApplicationDAO;
import com.example.model.DefaultResponse;
import com.example.model.User;
import com.example.service.ApplicationService;
import com.example.util.ApplicationEnums;
import com.example.util.ApplicationUtil;

/**
 * 
 * @author bekir.subasi
 *
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationDAO dao;

	public void setDao(ApplicationDAO dao) {
		this.dao = dao;
	}

	@Override
	public DefaultResponse register(User user) {
		if(user == null )
			return new DefaultResponse(Boolean.FALSE, "Paramters is null");
		else if(user.getName() == null || user.getName().trim().isEmpty())
			return new DefaultResponse(Boolean.FALSE, "Name is incorrect");
		else if(user.getSurname() == null || user.getSurname().trim().isEmpty())
			return new DefaultResponse(Boolean.FALSE, "Surname is incorrect");
		else if(user.getUsername() == null || user.getUsername().trim().isEmpty())
			return new DefaultResponse(Boolean.FALSE, "Username is incorrect");
		else if(user.getPassword() == null || user.getPassword().trim().isEmpty())
			return new DefaultResponse(Boolean.FALSE, "Password is incorrect");
		
		boolean result = dao.saveUser(user);
		if(result)
			return new DefaultResponse(Boolean.TRUE, "User registered successfuly");
		
		return new DefaultResponse(Boolean.FALSE, "User registered error");
	}

	@Override
	public DefaultResponse authenticate(String username, String password) {
		
		if(username == null || password == null)
			return new DefaultResponse(Boolean.FALSE, "Username or Password is incorrect");
		
		User user = dao.getUserByUserName(username);
		if(user != null && password.equals(user.getPassword()))
			return new DefaultResponse(Boolean.TRUE, "Welcemo "+user.getName());
		
		
		return new DefaultResponse(Boolean.FALSE, "Username or Password is incorrect");
	}
	
	

	@Override
	public List<User> getAllUser() {
		List<User> users = dao.getAllUser();
		return users;
	}

	@Override
	public DefaultResponse deleteUser(String username) {
		boolean result = dao.deleteUser(username);
		if(result)
			return new DefaultResponse(Boolean.FALSE, "User deleted");
		
		return new DefaultResponse(Boolean.FALSE, "User can not be delete baby");
	}
	

	@Override
	public String getPopularURL() {
		StringBuilder builder = new StringBuilder();
		for (ApplicationEnums.PopularURL urlEnum : ApplicationEnums.PopularURL.values()) {
			builder.append("<a href=\"" + urlEnum.getUrl() + "\">");
			builder.append(urlEnum.name());
			builder.append("</a><br>");
		}
		return builder.toString();
	}


}
