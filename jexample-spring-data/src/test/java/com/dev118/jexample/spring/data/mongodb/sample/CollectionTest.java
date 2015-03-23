package com.dev118.jexample.spring.data.mongodb.sample;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev118.jexample.spring.data.mongodb.MongoTemplateTest;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class CollectionTest extends MongoTemplateTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAll() {
		DB db = mongoTemplate.getDb();
		Set<String> collections = db.getCollectionNames();
		System.out.printf("输出%s下所有collection的名字\n", db.getName());
		for (String collectionName : collections) {
			DBCollection collection = db.getCollection(collectionName);
			System.out.println(collection.getName());
		}
	}
	
	public void testCreate() {}
	
	public void testDrop() {}
	
	public void testRename() {}

}
