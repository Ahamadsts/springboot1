package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Subject;


public interface SubjectService {
	
	
	public List<Subject> getAllSubjectOfStudent(int studentId); // get list of subject of a particular student
	
	public String deleteSubject(int subjectId); 
	
	public String updateSubject(Subject subject);  

}
