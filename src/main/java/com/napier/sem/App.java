package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App {
    public static void main(String[] args) {
        // Connect to MongoDB container on the Docker network
        MongoClient mongoClient = new MongoClient("mongo-dbserver", 27017);

        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("test");

        Document doc = new Document("name", "Kevin Sim")
                .append("class", "DevOps")
                .append("year", "2024")
                .append("result", new Document("CW", 95).append("EX", 85));

        collection.insertOne(doc);

        Document myDoc = collection.find().first();
        if (myDoc != null) {
            System.out.println(myDoc.toJson());
        }

        mongoClient.close();
    }
}