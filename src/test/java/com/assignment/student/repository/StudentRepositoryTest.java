package com.assignment.student.repository;

import java.util.List;

import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.assignment.student.TestData;
import com.assignment.student.entity.StudentBO;
import com.assignment.student.util.MongoClientUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RunWith(MockitoJUnitRunner.Silent.class)
//@RunWith(PowerMockRunner.class)
public class StudentRepositoryTest {
	
	@Mock
	MongoClientUtil util;
	
	@InjectMocks
	StudentRepository studentRepository;

	@Test
	public void save() {
		MongoClient mongo = Mockito.mock(MongoClient.class);
		MongoDatabase db = Mockito.mock(MongoDatabase.class);
		MongoCollection<Document> dbCollection = Mockito.mock(MongoCollection.class);
	
		Mockito.when(util.getClient()).thenReturn(mongo);
		Mockito.when(mongo.getDatabase("StudentsDB")).thenReturn(db);
		Mockito.when(db.getCollection("students")).thenReturn(dbCollection);
		
		
		StudentBO student =TestData.getStudent();		
		studentRepository.save(student);
	}
	
	@Test
	public void getStudents()
	{
		MongoClient mongo = Mockito.mock(MongoClient.class);
		MongoDatabase db = Mockito.mock(MongoDatabase.class);
		MongoCollection<Document> studentsCollection = Mockito.mock(MongoCollection.class);
		
		Document user1 = new Document(); 
		user1.append("firstName","Venkatesh");
		user1.append("lastName","kesa"); 
		user1.append("department","MBA");
		user1.append("age","21");
		user1.append("grade","C");
		
		studentsCollection.insertOne(user1);
	
		Mockito.when(util.getClient()).thenReturn(mongo);
		Mockito.when(mongo.getDatabase("StudentsDB")).thenReturn(db);
		Mockito.when(db.getCollection("students")).thenReturn(studentsCollection);
		//Mockito.when(studentsCollection.count()).thenReturn((long) 2);
		//Mockito.when(studentsCollection.find()).thenReturn(doc);
		 
		studentRepository.getStudents();
	}
	
	@Test
	public void updateStudents()
	{
		MongoClient mongo = Mockito.mock(MongoClient.class);
		MongoDatabase db = Mockito.mock(MongoDatabase.class);
		MongoCollection<Document> dbCollection = Mockito.mock(MongoCollection.class);
		
	
		Mockito.when(util.getClient()).thenReturn(mongo);
		Mockito.when(mongo.getDatabase("StudentsDB")).thenReturn(db);
		Mockito.when(db.getCollection("students")).thenReturn(dbCollection);
		
		StudentBO student =TestData.getStudent();
		studentRepository.updateStudents(student);
	}
	
	@Test
	public void deleteStudent()
	{ 
		MongoClient mongo = Mockito.mock(MongoClient.class);
		MongoDatabase db = Mockito.mock(MongoDatabase.class);
		BasicDBObject dbObject = Mockito.mock(BasicDBObject.class);
		MongoCollection<Document> dbCollection = Mockito.mock(MongoCollection.class);
	
		Mockito.when(util.getClient()).thenReturn(mongo);
		Mockito.when(mongo.getDatabase("StudentsDB")).thenReturn(db);
		Mockito.when(db.getCollection("students")).thenReturn(dbCollection);
		
		
		studentRepository.deleteStudent("xyzsdguyr4irjl3122i2p23ps123");
	}
}
