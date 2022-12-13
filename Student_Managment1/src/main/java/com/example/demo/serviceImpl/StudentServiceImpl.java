package com.example.demo.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.SubjectRepo;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
	{
	
	@Autowired
	StudentRepo studentrepo;
	
	@Autowired
	SubjectRepo subjectrepo;
	
	@Override
	public Student saveStudent(Student student) 
	{
		try
		{
		Student st=new Student();
		st.setFirstName(student.getFirstName());
		st.setLastName(student.getLastName());
		st.setEmail(student.getEmail());
		st.setAddress(student.getAddress());
		st.setphone_no(student.getphone_no());
		
		Student savedstudent = studentrepo.save(st);
		List<Subject>  subjectList= student.getSubject();
		for(Subject subject:subjectList) {
			   subject.setStudent(savedstudent);
			   this.subjectrepo.save(subject);
		}
		System.out.println("Student Saved Successfully");
		return savedstudent;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String deleteStudent(int studentid) 
	{
		try 
		{
			studentrepo.deleteById(studentid);
			System.out.println("Student Deleted Successfully");
			return "Student Deleted Successfully";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "Student Not Deleted";
		}
	}
	
	@Override
	public String updateStudent(Student student) 
	{
		try
		{
			Student save_student=studentrepo.findById(student.getId()).get();
			save_student.setFirstName(student.getFirstName());
			save_student.setLastName(student.getLastName());
			save_student.setEmail(student.getEmail());
			save_student.setAddress(student.getAddress());
			save_student.setphone_no(student.getphone_no());
			save_student.setSubject(student.getSubject());
			this.studentrepo.save(save_student);
			System.out.println("Student Updated Successfully");
			return "Student Updated Successfully";
		}
		catch (Exception e) 
		{
			e.getMessage();
			return "Student Not Updated Something Went Wrong";
		}
	}
}
