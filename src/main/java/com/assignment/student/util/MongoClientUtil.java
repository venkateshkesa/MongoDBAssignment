package com.assignment.student.util;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class MongoClientUtil {

	private MongoClient client;
	
	public MongoClient getClient()
	{
		if(client==null)
		{
			client=new MongoClient("localhost", 27025);
		}
		return client;
	}

	public MongoCollection<Document> getCollection()
	{
		MongoClient client = getClient(); 
		MongoDatabase  database = client.getDatabase("StudentsDB");
		MongoCollection<Document> studentsCollection = database.getCollection("students");
		return studentsCollection;
	}
}
