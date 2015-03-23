package com.dev118.jexample.spring.data.mongodb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.dev118.jexample.spring.data.SpringJunitMongoDBTest;
import com.dev118.jexample.spring.data.mongodb.entity.User;

public class UserDAOTest extends SpringJunitMongoDBTest {

	@Resource
	private UserDAO userDAO;

	@Test
	public void testSave() {
		User user = new User("wenchuanke", "wenchuanke");
		userDAO.save(user);
		System.out.println(user);
	}

	@Test
	public void testFindAll() {
		List<User> users = userDAO.findAll();
		Assert.assertNotNull(users);
		System.out.println(users);
	}

}