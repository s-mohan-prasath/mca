import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoDBCRUD {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "testdb";
    private static final String COLLECTION_NAME = "users";

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            insertData(collection, "Alice", "alice@example.com");
            readData(collection);
            updateData(collection, "Alice", "alice@newmail.com");
            deleteData(collection, "Alice");
        }
    }

    private static void insertData(MongoCollection<Document> collection, String name, String email) {
        Document doc = new Document("name", name).append("email", email);
        collection.insertOne(doc);
        System.out.println("Document inserted.");
    }

    private static void readData(MongoCollection<Document> collection) {
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }

    private static void updateData(MongoCollection<Document> collection, String name, String newEmail) {
        collection.updateOne(Filters.eq("name", name), new Document("$set", new Document("email", newEmail)));
        System.out.println("Document updated.");
    }

    private static void deleteData(MongoCollection<Document> collection, String name) {
        collection.deleteOne(Filters.eq("name", name));
        System.out.println("Document deleted.");
    }
}
