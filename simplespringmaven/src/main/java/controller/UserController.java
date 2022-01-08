package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.UserService;
import serviceimpl.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/*
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserController() {
		userService = new UserServiceImpl();
	}*/
	public void doGet() {
		userService.getUser();
	}
}
