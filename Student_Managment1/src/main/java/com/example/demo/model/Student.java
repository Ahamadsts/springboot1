package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(unique = true)
	private String lastName;
	
	@Column(nullable = false)
	private String address;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private long phone_no;
	
	@OneToMany (mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true)
	List<Subject>subject;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getphone_no() {
		return phone_no;
	}
	public void setphone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public List<Subject> getSubject() {
		return subject;
	}
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", email=" + email + ", phone_no=" + phone_no + ", subject=" + subject + "]";
	}
	public Student(int id, String firstName, String lastName, String address, String email, long phone_no,
			List<Subject> subject) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone_no = phone_no;
		this.subject = subject;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}

