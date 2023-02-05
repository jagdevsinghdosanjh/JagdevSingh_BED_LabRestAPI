package com.greatlearning.srs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.srs.model.Student;

public interface StudentRepository 
	extends JpaRepository<Student, Integer> {

}