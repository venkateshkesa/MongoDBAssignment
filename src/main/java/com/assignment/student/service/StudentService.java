package com.assignment.student.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.student.entity.StudentBO;
import com.assignment.student.repository.StudentRepository;

@Service
public class StudentService {

	 Logger logger = LoggerFactory.getLogger(StudentService.class);
	 
	@Autowired
	StudentRepository studentRepository;
	 
	public String saveStudent(StudentBO student) {
		logger.info("Entered into saveStudent Service");
		String response =studentRepository.save(student);
		return response;
	}

	public List<StudentBO> getStudents() {
		logger.info("Entered into getStudent Service");
		return studentRepository.getStudents();
	}

	public String deleteStudent(String id) {
		logger.info("Entered into deleteStudent Service");
		return studentRepository.deleteStudent(id);
	}
	
	public String updateStudents(StudentBO student) {
		logger.info("Entered into updateStudent Service");
		return studentRepository.updateStudents(student);
	}
}
