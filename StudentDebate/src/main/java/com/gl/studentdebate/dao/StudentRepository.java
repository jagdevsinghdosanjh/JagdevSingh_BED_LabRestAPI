package com.gl.studentdebate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.studentdebate.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
