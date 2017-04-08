package com.example.controller;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBootAngularDemoApplication;
import com.example.model.DefaultResponse;
import com.example.model.User;
import com.example.service.ApplicationService;

@RestController
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@RequestMapping("/")
	public ModelAndView welcomePage() {
		return new ModelAndView("redirect:" + "/index.html");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public DefaultResponse register(@RequestBody User user) {
		return applicationService.register(user);
	}
	
	@RequestMapping("/authenticate")
	public DefaultResponse authenticate(@RequestParam("username") String username, @RequestParam("password") String password) {
		return applicationService.authenticate(username, password);
	}
	
	
	@RequestMapping("/users")
	public List<User> users() {
		return applicationService.getAllUser();
	}
	
	
	
	@RequestMapping("/delete")
	public DefaultResponse delete(@RequestParam("username") String username) {
		return applicationService.deleteUser(username);
	}
	
	

	@RequestMapping("/ping")
	@ResponseBody
	public String ping() {
		return MessageFormat.format("Server started at {0}", SpringBootAngularDemoApplication.startTime);
	}

	@RequestMapping("/popularURL")
	public String urlList() {
		return applicationService.getPopularURL();
	}

}
