import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDemoConnection {

	public static void main(String args[]) {

		try {
			MongoClient mongoClients = MongoClients.create(new ConnectionString("mongodb://localhost:27017"));

			MongoDatabase db = mongoClients.getDatabase("app");
			MongoCollection<Document> table = db.getCollection("scores");
			// Document doc = new Document("name", "Abha Singh");
			// table.insertOne(doc);
			// for(int i =0; i< table.count();i++)
			// ArrayList<Document> d = new ArrayList<Document>();
			// d.add(table.find().first());
			MongoCursor<Document> cursor = table.find().iterator();
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
