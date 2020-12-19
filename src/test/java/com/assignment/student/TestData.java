package com.assignment.student;

import org.bson.Document;

import com.assignment.student.entity.StudentBO;
import com.mongodb.client.MongoCollection;

public class TestData {
	
	public static StudentBO getStudent()
	{
		StudentBO studentBO = new StudentBO();
		studentBO.set_id("123def4567dsgds");
		studentBO.setAge((long) (22));
		studentBO.setFirstName("Venkatesh");
		studentBO.setLastName("Kesa");
		studentBO.setGrade("A");
		
		return studentBO;
	}

}
