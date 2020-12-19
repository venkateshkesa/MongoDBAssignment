package com.assignment.student.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.assignment.student.TestData;
import com.assignment.student.entity.StudentBO;
import com.assignment.student.repository.StudentRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StudentServiceTest {
	
	@Mock
	StudentRepository studentRepository;
	
	@InjectMocks
	StudentService studentService;
	
	@Test
	public void saveStudentTest()
	{
		Mockito.when(studentRepository.save(TestData.getStudent())).thenReturn("Successfully Inserted");
		studentService.saveStudent(TestData.getStudent());
	}
	
	@Test
	public void getStudentsTest()
	{
		StudentBO testObject = TestData.getStudent();
		List<StudentBO> students = new ArrayList<StudentBO>();
		students.add(testObject);
		
		Mockito.when(studentRepository.getStudents()).thenReturn(students);
		studentService.getStudents();
	}
	
	@Test
	public void updateStudentTest()
	{
		Mockito.when(studentRepository.updateStudents(TestData.getStudent())).thenReturn("Successfully Updated");
		studentService.updateStudents(TestData.getStudent());
	}
	
	@Test
	public void deleteStudentTest()
	{
		Mockito.when(studentRepository.deleteStudent(TestData.getStudent().get_id())).thenReturn("Successfully Deleted");
		studentService.deleteStudent(TestData.getStudent().get_id());
	}
	

}
