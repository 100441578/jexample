package com.dev118.jexample.spring.data.mongodb;

import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public final class MongDBUtils {

	private static final String SYSTEM_INDEXES = "system.indexes";

	private MongDBUtils() {
		super();
	}

	/**
	 * 
	 * @param db
	 */
	public static void collectionDropAll(DB db) {
		Set<String> collectionNames = db.getCollectionNames();
		DBCollection dbCollection;
		for (String collectionName : collectionNames) {
			if (SYSTEM_INDEXES.equals(collectionName) == false) {
				dbCollection = db.getCollection(collectionName);
				dbCollection.drop();
			}
		}
	}

}
