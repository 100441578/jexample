package com.dev118.jexample.spring.data.jpa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev118.jexample.spring.data.jpa.entity.User;
import com.dev118.jexample.spring.data.jpa.entity.type.UserCategoryType;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByUsername(String username);

	public Page<User> findByUserCategoryType(UserCategoryType userCategoryType, Pageable pageable);
}
