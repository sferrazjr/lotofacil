package br.com.jogatina.lotofacil.util;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;
import com.mongodb.ServerAddress;

public class ArrumaData {

	public static void main(String[] args) throws UnknownHostException  {
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

		DB database = client.getDB("jogatina");

		final DBCollection lotofacilCollection = database.getCollection("lotofacil");

		final DBCursor lotofacilCursor = database.getCollection("lotofacil").find();

		for (Iterator iterator = lotofacilCursor.iterator(); iterator.hasNext();) {
			BasicDBObject doc = (BasicDBObject) iterator.next();

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date data = formatter.parse(doc.getString("data"));
				System.out.println(doc);
				
				BasicDBObject o = (BasicDBObject) doc.copy();
				o.append("data", data);
				lotofacilCollection.update(new BasicDBObject("_id", doc.getString("_id")), o);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}
		
	}

}
