package br.com.jogatina.lotofacil.util;

import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class FinalMongoExam7 {

	public static void main(String[] args) throws Exception {
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

		DB database = client.getDB("test");

		final DBCollection albumsCollection = database.getCollection("albums");
		
		final DBCollection imagesCollection = database.getCollection("images");

		final DBCursor imagesCursor = database.getCollection("images").find();

		for (Iterator iterator = imagesCursor.iterator(); iterator.hasNext();) {
			
			BasicDBObject image = (BasicDBObject) iterator.next();
			
			int imageId = image.getInt("_id");
			
			BasicDBObject o = new BasicDBObject("images", imageId);
			
			DBCursor imagesInAlbum = albumsCollection.find(o);
			
			if(imagesInAlbum.size()==0){
				imagesCollection.remove(new BasicDBObject("_id",imageId));
				System.out.println("Removed: " + imageId);
			}
			
			
			
		}
		
	}

}
