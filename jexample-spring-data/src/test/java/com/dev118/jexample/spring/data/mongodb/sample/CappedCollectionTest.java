package com.dev118.jexample.spring.data.mongodb.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dev118.jexample.spring.data.mongodb.MongDBUtils;
import com.dev118.jexample.spring.data.mongodb.MongoTemplateTest;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * <p>
 * Capped Collection 具有以下特性，在使用的时候需要注意
 * <p>
 * <ul>
 * <li>不可以对 Capped Collection 进行分片。</li>
 * <li>在 2.2 版本以后，创建的Capped Collection 默认在 _id 字段上创建索引，而在 2.2 版本或以前没有。</li>
 * <li>在 Capped Collection 插入文档后可以进行更新(update)操作，当更新不能导致原来文档占用空间增长，否则更新失败。</li>
 * <li>不可以对 capped collection 执行删除文档操作，但可以删除整个集合</li>
 * </ul>
 * 
 * @author Wen
 *
 */
public class CappedCollectionTest extends MongoTemplateTest {

	private static final String OPTION_CAPPED = "capped";

	private static final String OPTION_SIZE = "size";

	private static final String OPTION_MAX = "max";

	private static final String CAPPED_TEST_COLLECTION = "CappedTest";

	private DBObject options;

	private DBCollection collection;

	@Before
	public void setUp() throws Exception {
		// 清除所有表
		MongDBUtils.collectionDropAll(mongoTemplate.getDb());
		//
		options = new BasicDBObject();
		options.put(OPTION_CAPPED, true);
		// 文档大小，单位是byte
		options.put(OPTION_SIZE, 1000 * 5);
		// document条数
		options.put(OPTION_MAX, 100);
		// 创建collection
		collection = mongoTemplate.getDb().createCollection(
				CAPPED_TEST_COLLECTION, options);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCapped() {
		//
		Assert.assertTrue(collection.isCapped());
	}

	@Test
	public void testSize() {
		// 文档大小，单位是byte
		options.put(OPTION_SIZE, 1000 * 3);
		String collectionName = CAPPED_TEST_COLLECTION + 1;
		// 创建新的Collection
		collection = mongoTemplate.getDb().createCollection(collectionName,
				options);
		for (int i = 0; i < 200; i++) {
			collection.save(new BasicDBObject("name", "name" + i));
		}
		// 因文档大小限制，所以插入200条，collection确不足100条
		Assert.assertTrue(collection.getCount() < 100);
	}

	@Test
	public void testMax() {
		for (int i = 0; i < 200; i++) {
			collection.save(new BasicDBObject("name", "name" + i));
		}
		// 因文档条目数限制，所以插入200条，collection中只剩下100条
		Assert.assertTrue(collection.getCount() == 100);
	}

	@Test
	public void testUpdate() {
		// 条件
		BasicDBObject where = new BasicDBObject("age", 25);
		// 示例数据
		BasicDBObject dbObj = new BasicDBObject(where).append("name",
				"zhangsan");
		collection.save(dbObj);

		// 修改，修改内容比原内容大
		collection.update(where, new BasicDBObject("$set", new BasicDBObject(
				"name", "zhangsanfeng")));
		DBObject rs1 = collection.findOne(where);
		// 因修改内容比原来内容大，所以内容没有变
		Assert.assertTrue("zhangsan".equals(rs1.get("name")));

		// 修改，修改内容比原内容小
		collection.update(where, new BasicDBObject("$set", new BasicDBObject(
				"name", "zhang")));
		DBObject rs2 = collection.findOne(where);
		Assert.assertTrue("zhang".equals(rs2.get("name")));

	}

	@Test
	public void testRemove() {
		BasicDBObject dbObj = new BasicDBObject("name", "zhangsan");

		options.put(OPTION_CAPPED, false);
		// 创建新的Collection
		DBCollection collection1 = mongoTemplate.getDb().createCollection(
				CAPPED_TEST_COLLECTION + 1, options);
		collection1.save(dbObj);
		collection1.remove(dbObj);
		// 删除记录后总记录数为0
		Assert.assertTrue(collection1.getCount() == 0);

		// **************************************************

		collection.save(dbObj);
		collection.remove(dbObj);
		// 删除记录后总记录数还是1
		Assert.assertTrue(collection.getCount() == 1);

	}

}
