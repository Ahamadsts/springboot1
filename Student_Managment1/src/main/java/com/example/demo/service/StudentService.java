package com.example.demo.service;


import com.example.demo.model.Student;


public interface StudentService {

	public Student saveStudent(Student student);
	
	public String deleteStudent(int id);
	
	public String updateStudent(Student student);
	
	
}