package com.assignment.student.controller;



import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.assignment.student.TestData;
import com.assignment.student.entity.StudentBO;
import com.assignment.student.service.StudentService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StudentControllerTest {
	
	@Mock
	StudentService studentService;

	@InjectMocks
	StudentController studentController;
	
	@MockBean
	StudentBO studentBO;
	
	@Test
	public void saveStudentTest()
	{
		String resp="Successfully Inserted";
		Mockito.when(studentService.saveStudent(TestData.getStudent())).thenReturn(resp);
		String response = studentController.saveStudent(TestData.getStudent());
		System.out.println(response);
		//equals(studentController.saveStudent(TestData.getStudent()));
		//Assert.notNull(studentController.saveStudent(TestData.getStudent()));
	}
	
	@Test
	public void getStudentsTest()
	{
		StudentBO testObject = TestData.getStudent();
		List<StudentBO> students = new ArrayList<StudentBO>();
		students.add(testObject);
		
		Mockito.when(studentService.getStudents()).thenReturn(students);
		studentController.getStudents();
	} 
	
	@Test
	public void updateStudentsTest()
	{	
		Mockito.when(studentService.updateStudents(TestData.getStudent())).thenReturn("Successfully Updated");
		studentController.updateStudents(TestData.getStudent());
	}
	
	@Test
	public void updateStudentsNullTest()
	{
		StudentBO testObject = TestData.getStudent();
		testObject.setAge(null);
		testObject.setGrade("");
		Mockito.when(studentService.updateStudents(TestData.getStudent())).thenReturn("Successfully Updated");
		studentController.updateStudents(testObject);
	}
	
	@Test
	public void deleteStudntTest()
	{	
		Mockito.when(studentService.deleteStudent(TestData.getStudent().get_id())).thenReturn("Successfully Updated");
		studentController.deleteStudent(TestData.getStudent().get_id());
	}
	
	
}
