package com.assignment.student.entity;

public class StudentBO {
	private String _id;
	private String firstName;
	private String lastName;
	private String department;
	private Long age;
	private String grade;
	
	public StudentBO() {
		super();
	}

	public StudentBO(String _id,String firstName, String lastName, String department, Long age, String grade) {
		super();
		this._id = _id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.age = age;
		this.grade = grade;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "StudentBO [_id=" + _id + ",firstName=" + firstName + ", lastName=" + lastName + ", department=" + department + ", age="
				+ age + ", grade=" + grade + "]";
	}

}
