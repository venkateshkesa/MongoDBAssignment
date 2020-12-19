package com.assignment.student.repository;

import java.util.ArrayList;
import java.util.List;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment.student.entity.StudentBO;
import com.assignment.student.util.MongoClientUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@Repository
public class StudentRepository {

	Logger logger = LoggerFactory.getLogger(StudentRepository.class);
	
	@Autowired
	MongoClientUtil util;
	
	String response;
	
	public String save(StudentBO student) {
		logger.info("Entered into saveStudent Repository");
		MongoClient client =util.getClient();
		MongoDatabase  database = client.getDatabase("StudentsDB");
		MongoCollection<Document> studentsCollection = database.getCollection("students");
		
		Document user1 = new Document(); 
		user1.append("firstName",student.getFirstName());
		user1.append("lastName",student.getLastName()); 
		user1.append("department",student.getDepartment());
		user1.append("age",student.getAge());
		user1.append("grade",student.getGrade());
		
		try {
		studentsCollection.insertOne(user1);
		response= "Successfully Inserted";
		}catch(Exception e)
		{
			response ="Insertion failed with Exception" +e;
		}
		return response;
	}

	public List<StudentBO> getStudents() {
		logger.info("Entered into getStudent Repository");
		MongoClient client =util.getClient();
		MongoDatabase  database = client.getDatabase("StudentsDB");
		MongoCollection<Document> studentsCollection = database.getCollection("students");
		
		List<StudentBO> studentsList = new ArrayList<StudentBO>();
		
		if(studentsCollection.count()!=0) {
		for(Document e: studentsCollection.find())
		{
			StudentBO student = new StudentBO();
			student.setAge(e.getLong("age"));
			student.setFirstName(e.getString("firstName"));
			student.setLastName(e.getString("lastName"));
			student.setDepartment(e.getString("department"));
			student.setGrade(e.getString("grade"));
			
			studentsList.add(student);
		}
		return studentsList;
		}else {
			return studentsList;
		}
	}

	public String deleteStudent(String id) {
		logger.info("Entered into deleteStudent Repository");
		MongoClient client =util.getClient();
		MongoDatabase  database = client.getDatabase("StudentsDB");
		MongoCollection<Document> studentsCollection = database.getCollection("students");
		
		try {
			BasicDBObject filterObj = new BasicDBObject("_id",new ObjectId(id));
			studentsCollection.deleteOne(filterObj);
			response = "Successfully updated";
		}catch(Exception e)
		{
			response ="Insertion failed with Exception" +e;
		}
		
		return response;
	}
	
	public String updateStudents(StudentBO student) {
		logger.info("Entered into updateStudent Repository");
		MongoClient client =util.getClient();
		MongoDatabase  database = client.getDatabase("StudentsDB");
		MongoCollection<Document> studentsCollection = database.getCollection("students");
		
		Document user1 = new Document(); 
		user1.append("firstName",student.getFirstName());
		user1.append("lastName",student.getLastName()); 
		user1.append("department",student.getDepartment());
		user1.append("age",student.getAge());
		user1.append("grade",student.getGrade());
		
		try {
			BasicDBObject filterObj = new BasicDBObject(); //("_id",new ObjectId(student.get_id()));
			filterObj.put("age",student.getAge());
			filterObj.put("grade",student.getGrade());
			studentsCollection.updateMany(filterObj, new BasicDBObject("$set",user1));
			response = "Successfully updated";
		}catch(Exception e)
		{
			response ="Insertion failed with Exception" +e;
		}
		
		return response;
	}
}
