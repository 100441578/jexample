package com.dev118.jexample.spring.data.jpa.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dev118.jexample.spring.data.SpringJunitJpaTest;
import com.dev118.jexample.spring.data.jpa.entity.Car;
import com.dev118.jexample.spring.data.jpa.entity.CarPK;

public class CarDaoTest extends SpringJunitJpaTest {

	@Autowired
	private CarDao carDao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		Car car = new Car(new CarPK("辽", "B", "123A5"), "白色", "日产", "GTR2015款3.8T");
		carDao.save(car);
	}

}
