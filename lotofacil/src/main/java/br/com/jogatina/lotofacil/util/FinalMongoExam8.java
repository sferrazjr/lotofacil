package br.com.jogatina.lotofacil.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class FinalMongoExam8 {

	public static void main(String[] args) throws Exception {
		MongoClient c =  new MongoClient(new MongoClientURI("mongodb://localhost"));
		DB db = c.getDB("test");
		DBCollection animals = db.getCollection("animals");

		BasicDBObject animal = new BasicDBObject("animal", "monkey");

		animals.insert(animal);
		animal.removeField("animal");
		animal.append("animal", "cat");
		animals.insert(animal);
		animal.removeField("animal");
		animal.append("animal", "lion");
		animals.insert(animal);
	}

}
