package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.serviceImpl.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	StudentServiceImpl studserviceimpl;
	
	
	
	@RequestMapping("saveStudent")
	public ResponseEntity<?> saveStudent(@RequestBody Student student)
	{
		Student saved_student= studserviceimpl.saveStudent(student);
		
		   
		 return new ResponseEntity<>(saved_student,HttpStatus.OK);
	}
	
	
	@RequestMapping("deleteStudent")
	public ResponseEntity<?> deleteStudent(@RequestParam int studentId)
	{
		 String deleteStudent = studserviceimpl.deleteStudent(studentId);
		 return new ResponseEntity<>(deleteStudent,HttpStatus.OK);

	}
	
	
	@RequestMapping("updateStudent")
	public ResponseEntity<?> upadtestudent(@RequestBody Student student)
	{
		String updateStudent = this.studserviceimpl.updateStudent(student);
		return new ResponseEntity<>(updateStudent,HttpStatus.OK);
	}
}
