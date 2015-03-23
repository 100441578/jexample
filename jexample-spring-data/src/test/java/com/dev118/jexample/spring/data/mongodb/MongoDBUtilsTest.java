package com.dev118.jexample.spring.data.mongodb;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;

public class MongoDBUtilsTest extends MongoTemplateTest {

	@Before
	public void setUp() throws Exception {
		MongDBUtils.collectionDropAll(mongoTemplate.getDb());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void collectionDropAllTest() {
		DB db = mongoTemplate.getDb();
		// 系统Collection数量
		int sysSize = db.getCollectionNames().size();

		DBObject options = new BasicDBObject("capped", false).append("size",
				1000 * 5).append("max", 100);
		db.createCollection("test1", options);
		db.createCollection("test2", options);

		Assert.assertTrue(db.getCollectionNames().size() - sysSize == 2);
		// 调用被测试方法
		MongDBUtils.collectionDropAll(mongoTemplate.getDb());

		Assert.assertTrue(db.getCollectionNames().size() - sysSize == 0);
	}

}
