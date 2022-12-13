package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.SubjectRepo;
import com.example.demo.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired 
	StudentRepo studentrepo;
	
	@Autowired 
	SubjectRepo subjectrepo;

	@Override
	public List<Subject> getAllSubjectOfStudent(int studentId) 
	{
		try
		{
			  Student saved_student=this.studentrepo.findById(studentId).orElseThrow();
			  if(saved_student==null) {
				  return null;
			  }
			       List<Subject> list= this.subjectrepo.getAll(studentId);
			       return list;
		}
		catch (Exception e)
		{
			e.getMessage();
			return null;
		}
	
	}
	@Override
	public String deleteSubject( int subId)
	{
		try 
		{
		subjectrepo.deleteById(subId);
		return "Successfully Deleted";
		} 
		
		catch (Exception e) 
		{
			e.getMessage();
			return "Something Went Wrong";
		}
	}
	@Override
	public String updateSubject(Subject subject) 
	{
		try
		{
		Subject sub = this.subjectrepo.findById(subject.getId()).get();
		sub.setName(subject.getName());
		sub.setStudent(subject.getStudent());
		this.subjectrepo.save(sub);
		return "Subject Updates Successfully";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "Something Went Wrong";
		}
	}
}
