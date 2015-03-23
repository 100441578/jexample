package com.dev118.jexample.spring.data.mongodb.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev118.jexample.spring.data.mongodb.MongDBUtils;
import com.dev118.jexample.spring.data.mongodb.MongoTemplateTest;

public class QueryTest extends MongoTemplateTest {

	@Before
	public void setUp() throws Exception {
		MongDBUtils.collectionDropAll(mongoTemplate.getDb());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findOne() {
	}

	@Test
	public void findAll() {
	}

	@Test
	public void findCount() {
	}

}
