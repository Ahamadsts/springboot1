package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Subject;
import com.example.demo.serviceImpl.SubjectServiceImpl;

@RestController
public class SubjectController {

	//this is subject controller
	@Autowired 
	SubjectServiceImpl subjectserviceimpl;
	
	
	@RequestMapping("getAllSubject")
	public ResponseEntity<?> getAllSubjectOfStudent(@RequestParam("studentId") int studentId)
	{
		
	List<Subject>	list= this.subjectserviceimpl.getAllSubjectOfStudent(studentId);
		  return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping("deleteSubject")
	public ResponseEntity<?> deleteSubject(@RequestParam int subjectId)
	{
		 String deleteSubject = this.subjectserviceimpl.deleteSubject(subjectId);
		 return new ResponseEntity<>(deleteSubject,HttpStatus.OK);
	}
	
	@RequestMapping("updateSubject")
	public ResponseEntity<?> updateSubject(@RequestBody Subject subject)
	{
		 String updateSubject = this.subjectserviceimpl.updateSubject(subject);
		 return new ResponseEntity<>(updateSubject,HttpStatus.OK);
		
	}
	
	

}
