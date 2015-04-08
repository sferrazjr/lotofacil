package br.com.jogatina.lotofacil.util;

import java.util.ArrayList;
import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class FinalMongoExam5 {

	public static void main(String[] args) throws Exception {
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

		DB database = client.getDB("test");

		final DBCollection lotofacilCollection = database.getCollection("fubar");

		for (int i = 0; i < 6000; i++) {
			
			BasicDBObject o = new BasicDBObject().append("a", i).append("b", i).append("c", i);
			
			lotofacilCollection.insert(o);
			
		}

		
	}

}
