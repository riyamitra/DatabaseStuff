package appdao;

import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import app.AppUser;

public class AppUserDao extends BaseDatabaseDao {
	public static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	/*public void insertAppUser(AppUser appUser) {
		MongoDatabase db = getDB();
		Document doc = Document.parse(gson.toJson(appUser));
		db.getCollection("riyaCollection").insertOne(doc);
	}*/
	
	/*public void readUser(AppUser appUser) {
		MongoDatabase db = getDB();
		FindIterable<Document> filter = db.getCollection("riyaCollection").find();
		MongoCursor<Document> cursor = filter.iterator();
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
	}*/
	
	public void readUser(String key, Object value) {
		MongoDatabase db = getDB();
		BasicDBObject query = new BasicDBObject();
		query.put(key, value);
		FindIterable<Document> filter = db.getCollection("riyaCollection").find(query);
		MongoCursor<Document> cursor = filter.iterator();
					System.out.println(cursor.next().toJson());
	}
	
	
	public void deleteUser(String key, Object value) {
		MongoDatabase db = getDB();
		//AppUser appUser = new AppUser();
		BasicDBObject query = new BasicDBObject();
		query.put(key, value);
		System.out.println(" deleteing json is "+query.toJson());
		db.getCollection("riyaCollection").deleteOne(query);
		System.out.println("Row deleted");
		
	}
	
	//does not work
	/*public void deleteUser(String key, Object value) {
		MongoDatabase db = getDB();
		AppUser appUser = new AppUser();
		BasicDBObject query = new BasicDBObject();
		query.put(key, value);
		FindIterable<Document> filter = db.getCollection("riyaCollection").find(query);
		MongoCursor<Document> cursor = filter.iterator();
		cursor.remove();
		System.out.println("Document deleted");
	}*/
	
	
	/*public void updateUser(String key, Object value1, Object value2) {
		MongoDatabase db = getDB();
		BasicDBObject searchQuery = new BasicDBObject().append(key, value1);
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append(key, value2));
		
		db.getCollection("riyaCollection").updateOne(searchQuery, newDocument);
		System.out.println("Update Complete");
	}*/

	/*public void updateUser(String key1, String key2, Object value1, Object value2) {
		MongoDatabase db = getDB();
		BasicDBObject searchQuery = new BasicDBObject().append(key1, value1);
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append(key2, value2));
		
		db.getCollection("riyaCollection").updateOne(searchQuery, newDocument);
		System.out.println("Update Complete");
	}*/
	
	/*private void sort() {
		MongoDatabase db = getDB();
		
		}*/
	
	
	
	
	
	
	public AppUser find(String key, Object value) {
		AppUser appUser = new AppUser();
		MongoDatabase db = getDB();
		BasicDBObject query = new BasicDBObject();
		query.put(key, value);
		FindIterable<Document> filter = db.getCollection("riyaCollection").find(query);
		MongoCursor<Document> cursor = filter.iterator();
		try {
			String obj = cursor.next().toJson();
			System.out.println(obj);
			appUser = gson.fromJson(obj, AppUser.class); //?
		} catch (JsonSyntaxException jse) {
			jse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cursor.close();

		}
		return appUser;

	}
}
