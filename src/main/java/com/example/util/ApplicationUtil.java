package com.example.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.User;

public final class ApplicationUtil {
	
	protected static final Map<String, User> userList = new HashMap<String, User>();
	
	public static void createUser(User user){
		if(user.getId() < 0)
			user.setId(userList.size()+1);
		
		userList.put(user.getUsername(), user);
	}
	
	public static User getUserById(int id){
		for(User user : userList.values())
			if(user.getId() == id)
				return user;
		
		return null;
	}
	
	public static User getUserByUserName(String username){
		return userList.get(username);
	}
	
	public static List<User> getAllUser(){
		return new ArrayList<User>(userList.values());
	}
	
	public static boolean deleteUser(String username){
		if(!userList.containsKey(username))
			return Boolean.FALSE;
		
		userList.remove(username);		
		return Boolean.TRUE;
	}
	
}
