package com.dev118.jexample.mongodb;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

public class CRUDTest {

	private MongoClient mongoClient;

	private DBCollection dbCollection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// 主机地址指定，端口默认
		mongoClient = new MongoClient("localhost");
		// 指定主机地址和端口
		mongoClient = new MongoClient("localhost", 27017);
		// 指定主机地址、端口和配置选项
		mongoClient = new MongoClient(new ServerAddress("localhost", 27017), new MongoClientOptions.Builder().build());
		// 集群
		mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017), new ServerAddress("localhost", 27018), new ServerAddress(
				"localhost", 27019)));
		// 主机地址和端口默认配置
		mongoClient = new MongoClient();

		dbCollection = mongoClient.getDB("dev118_mongodb_test").getCollection("test");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(dbCollection.count());
	}

}
