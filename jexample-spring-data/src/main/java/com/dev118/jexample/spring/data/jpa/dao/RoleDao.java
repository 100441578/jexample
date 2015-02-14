package com.dev118.jexample.spring.data.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev118.jexample.spring.data.jpa.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
