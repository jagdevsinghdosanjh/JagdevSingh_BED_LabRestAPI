package com.greatlearning.srs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@Data

public class Student {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "FIRST_NAME")	
	private String firstName;

	@Column(name = "LAST_NAME")		
	private String lastName;
	
	@Column(name = "COURSE")		
	private String course;
	
	@Column(name = "COUNTRY")		
	private String country;
	
	public Student() {
		
	}
	
	public Student(String fname, String lname, String course, String country) {
		
		this.firstName = fname;
		this.lastName = lname;
		this.course = course;
		this.country = country;
				
	}
}