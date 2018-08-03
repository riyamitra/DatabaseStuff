import java.io.IOException;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class ConnectToDB {
 public static void main(String args[]) throws IOException {
		// Creating a Mongo client
		MongoClient mongoclient = new MongoClient("localhost", 27017);
		// Creating Credentials
		MongoCredential credential;
		credential = MongoCredential.createCredential("root", "riyadb", "root".toCharArray());
		System.out.println("Connected to the database successfully");
		
		
		
		
		
     
     
     
 }
}