package br.com.jogatina.lotofacil.util;

import java.util.ArrayList;
import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class CriaArrayDeBolas {

	public static void main(String[] args) throws Exception {
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

		DB database = client.getDB("jogatina");

		final DBCollection lotofacilCollection = database.getCollection("lotofacil");

		final DBCursor lotofacilCursor = database.getCollection("lotofacil").find();

		for (Iterator iterator = lotofacilCursor.iterator(); iterator.hasNext();) {
			BasicDBObject doc = (BasicDBObject) iterator.next();

			BasicDBObject o = (BasicDBObject) doc.copy();
//			o.append("Data", data);

/*			BasicDBObject o = new BasicDBObject("_id",doc.getString("_id")));
			o.append("Data", data);*/
			
			ArrayList bolas = new ArrayList();
			bolas.add(doc.getInt("Bola1"));
			bolas.add(doc.getInt("Bola2"));
			bolas.add(doc.getInt("Bola3"));
			bolas.add(doc.getInt("Bola4"));
			bolas.add(doc.getInt("Bola5"));
			bolas.add(doc.getInt("Bola6"));
			bolas.add(doc.getInt("Bola7"));
			bolas.add(doc.getInt("Bola8"));
			bolas.add(doc.getInt("Bola9"));
			bolas.add(doc.getInt("Bola10"));
			bolas.add(doc.getInt("Bola11"));
			bolas.add(doc.getInt("Bola12"));
			bolas.add(doc.getInt("Bola13"));
			bolas.add(doc.getInt("Bola14"));
			bolas.add(doc.getInt("Bola15"));
			
			o.append("numeros", bolas);

			lotofacilCollection.update(new BasicDBObject("_id", doc.getString("_id")), o);

		}
		
	}

}
