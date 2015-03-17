package com.dev118.jexample.spring.data;

import static org.junit.Assert.fail;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-data-jpa-config.xml" })
public class SpringJunitJpaTest {

	@Autowired
	private DataSource ds;

	@Test
	public void testDS() {
		try {
			System.out.println(ds.getConnection().getCatalog());
		} catch (Exception e) {
			e.printStackTrace();
			fail("DS ERROR");
		}
	}

}
