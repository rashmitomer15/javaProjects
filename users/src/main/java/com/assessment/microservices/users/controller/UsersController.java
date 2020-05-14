package com.assessment.microservices.users.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.microservices.users.entities.User;
import com.assessment.microservices.users.services.UsersService;

@RestController
@RequestMapping(value = "/user")
public class UsersController {

	@Value("${server.port}")
	private int port;

	@Resource
	UsersService usersService;

	@GetMapping(value = "/{id}")
	public User getUser(@PathVariable(name = "id") int userId) {
		System.out.println("Working from port " + port + " of user service");
		return usersService.getUserInfo(userId).get();
	}

	@PostMapping
	public User addUser(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age,
			@RequestParam(name = "email") String email) {
		System.out.println("Working from port " + port + " of user service");
		return usersService.addUserInfo(name, age, email);
	}

}
