package br.com.jogatina.lotofacil.util;

import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class ArrumaBolas {

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
			o.append("Bola1", Integer.parseInt(doc.getString("Bola1")));
			o.append("Bola2", Integer.parseInt(doc.getString("Bola2")));
			o.append("Bola3", Integer.parseInt(doc.getString("Bola3")));
			o.append("Bola4", Integer.parseInt(doc.getString("Bola4")));
			o.append("Bola5", Integer.parseInt(doc.getString("Bola5")));
			o.append("Bola6", Integer.parseInt(doc.getString("Bola6")));
			o.append("Bola7", Integer.parseInt(doc.getString("Bola7")));
			o.append("Bola8", Integer.parseInt(doc.getString("Bola8")));
			o.append("Bola9", Integer.parseInt(doc.getString("Bola9")));
			o.append("Bola10", Integer.parseInt(doc.getString("Bola10")));
			o.append("Bola11", Integer.parseInt(doc.getString("Bola11")));
			o.append("Bola12", Integer.parseInt(doc.getString("Bola12")));
			o.append("Bola13", Integer.parseInt(doc.getString("Bola13")));
			o.append("Bola14", Integer.parseInt(doc.getString("Bola14")));
			o.append("Bola15", Integer.parseInt(doc.getString("Bola15")));
			/*o.append("Arrecadacao", "0");
			o.append("Ganhadores", "5");
*/

			lotofacilCollection.update(new BasicDBObject("_id", doc.getString("_id")), o);

		}
		
	}

}
