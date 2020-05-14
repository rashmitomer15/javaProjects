package com.assessment.microservices.users.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.microservices.users.dao.UserDao;
import com.assessment.microservices.users.entities.User;
import com.assessment.microservices.users.services.UsersService;

@Service
public class DefaultUsersService implements UsersService {
	
   @Autowired
   UserDao userdao;

	@Override
	public Optional<User> getUserInfo(int userId) {
		// TODO Auto-generated method stub
		return userdao.findById(userId);
	}


	@Override
	public User addUserInfo(String name, int age, String email) {
		User userToAdd=new User();
		userToAdd.setAge(age);
		userToAdd.setName(name);
		userToAdd.setEmail(email);
		return userdao.save(userToAdd);
	}

}
