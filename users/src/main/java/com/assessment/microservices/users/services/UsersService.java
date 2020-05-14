package com.assessment.microservices.users.services;

import java.util.Optional;

import com.assessment.microservices.users.entities.User;

public interface UsersService {

	Optional<User> getUserInfo(int userId);

	User addUserInfo(String name, int age, String email);
}
