package com.dev118.jexample.spring.data.mongodb;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dev118.jexample.spring.data.SpringJunitMongoDBTest;

/**
 * @author Wen
 *
 */
public class MongoTemplateTest extends SpringJunitMongoDBTest {

	@Resource
	public MongoTemplate mongoTemplate;

	@Test
	public void test() {
		Assert.assertNotNull(mongoTemplate);
		System.out.println(mongoTemplate.getDb());
	}

}