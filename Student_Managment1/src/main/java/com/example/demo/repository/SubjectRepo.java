package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {

//	@Query("select n from Subject n where n.Student.id= :m")
//	
//	List<Subject> getAll(@Param("m") int  stud);
	
	
	@Query(value="select * from subject where student_id=:studentId",nativeQuery = true)
	List<Subject> getAll(@Param("studentId") int studentId);
	
}

