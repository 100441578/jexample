package com.dev118.jexample.spring.data.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev118.jexample.spring.data.jpa.entity.Car;
import com.dev118.jexample.spring.data.jpa.entity.CarPK;

public interface CarDao extends JpaRepository<Car, CarPK> {

}
