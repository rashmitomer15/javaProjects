package com.assessment.microservices.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assessment.microservices.users.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
