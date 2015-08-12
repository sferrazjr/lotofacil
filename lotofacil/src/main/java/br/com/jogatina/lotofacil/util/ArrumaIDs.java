package br.com.jogatina.lotofacil.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class ArrumaIDs {

	public static void main(String[] args) throws Exception {
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

		DB database = client.getDB("jogatina");

		final DBCollection temp = database.getCollection("temp");

		final DBCursor lotofacilCursor = database.getCollection("lotofacil").find();

		for (Iterator iterator = lotofacilCursor.iterator(); iterator.hasNext();) {
			BasicDBObject doc = (BasicDBObject) iterator.next();

			//BasicDBObject o = (BasicDBObject) doc.copy();
//			o.append("Data", data);

/*			BasicDBObject o = new BasicDBObject("_id",doc.getString("_id")));
			o.append("Data", data);*/
			
			
			
			BasicDBObject o = new BasicDBObject();
			o.append("_id", Integer.parseInt(doc.getString("_id")));
			try{
				o.append("data", doc.getDate("data"));
			} catch (Exception e){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date data = formatter.parse(doc.getString("data"));
				o.append("data", data);
			}
			
			
			try {
				o.append("arrecadacao", Double.parseDouble(doc.getString("arrecadacao")));
				o.append("ganhadores", Integer.parseInt(doc.getString("ganhadores")));
				o.append("numeros", doc.get("numeros"));
				
				temp.insert(o);
			} catch (Exception e){
				e.printStackTrace();
				System.err.println(e.getStackTrace().toString() + " " + doc.getString("_id"));
			}


		}
		
	}

}
