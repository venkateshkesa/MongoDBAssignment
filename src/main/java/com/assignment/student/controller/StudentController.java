package com.assignment.student.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.student.entity.StudentBO;
import com.assignment.student.service.StudentService;

@RestController
public class StudentController {

	 Logger logger = LoggerFactory.getLogger(StudentController.class);
	 
	 @Autowired
	 StudentService studentService;
	 
	@PostMapping("/api/saveStudent")
	public String saveStudent(@RequestBody StudentBO student)
	{
			logger.info("Entered into save Student Controller");
			String response = studentService.saveStudent(student);
			return response;
	}
	
	@GetMapping("/api/getStudents")
	public List<StudentBO> getStudents()
	{
		logger.info("Entered into getStudents Controller");
		return studentService.getStudents();
		
	}
	
	@DeleteMapping("/api/deleteStudent{id}")
	public String deleteStudent(@PathVariable("id") String id)
	{
		logger.info("Entered into Delete Student Controller");
		return studentService.deleteStudent(id);
	}
	
	@PutMapping("/api/updateStudents")
	public String updateStudents(@RequestBody StudentBO student)
	{
		logger.info("Entered into update Student Controller");
		if(student.getAge()==null && student.getGrade().isEmpty())
		{
			return "Student Age and Grade is Mandatory";
		}
		return studentService.updateStudents(student);
		
	}
}

