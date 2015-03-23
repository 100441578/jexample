package com.dev118.jexample.spring.data.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.dev118.jexample.spring.data.mongodb.entity.User;

public interface UserDAO extends MongoRepository<User, String> {

	@Query(value = "{ 'username' : ?0 }", fields = "{ 'username' : 1}")
	List<User> findByUserName(String username);

}
