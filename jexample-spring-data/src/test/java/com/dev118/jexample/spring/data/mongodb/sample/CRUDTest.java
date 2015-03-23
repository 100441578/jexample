package com.dev118.jexample.spring.data.mongodb.sample;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dev118.jexample.spring.data.mongodb.MongDBUtils;
import com.dev118.jexample.spring.data.mongodb.MongoTemplateTest;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class CRUDTest extends MongoTemplateTest {

	private DBCollection collection;

	@Before
	public void setUp() throws Exception {
		MongDBUtils.collectionDropAll(mongoTemplate.getDb());
		collection = mongoTemplate.getCollection("book");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOne() {

		BasicDBObject obj = new BasicDBObject();
		obj.put("name", "MongoDB");
		obj.put("ver", 1.2);

		List<BasicDBObject> oldVer = new ArrayList<BasicDBObject>();
		oldVer.add(new BasicDBObject("ver", 1.0));
		oldVer.add(new BasicDBObject("ver", 1.1));
		obj.put("oldVer", oldVer);

		collection.save(obj);

	}

	@Test
	public void testSave() {
		collection.save(new BasicDBObject("name", "MongoDB"));
	}

	@Test
	public void testInsert() {
		DBObject obj1 = new BasicDBObject("name", "MongoDB2.3");
		DBObject obj2 = new BasicDBObject("name", "MongoDB2.4");
		collection.insert(obj1, obj2);
		//
		List<DBObject> list = new ArrayList<DBObject>();
		list.add(new BasicDBObject("name", "zhangsan"));
		list.add(new BasicDBObject("name", "lisi"));
		collection.insert(list);
	}

	@Test
	public void testRemove() {
		BasicDBObject where = new BasicDBObject("OS", "OSX");
		DBObject obj1 = new BasicDBObject(where).append("name", "MongoDB2.3");
		DBObject obj2 = new BasicDBObject(where).append("name", "MongoDB2.4");
		collection.insert(obj1, obj2);

		collection.remove(where);
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testFindOne() {

	}

	@Test
	public void testFindAll() {
	}

	@Test
	public void testCount() {
	}

}
