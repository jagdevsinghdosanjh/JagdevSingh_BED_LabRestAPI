package com.gl.studentdebate.service;

import java.util.List;

import com.gl.studentdebate.model.Student;

public interface StudentService {
	public List<Student> getStudents();

	public Student save(Student student);

	public Student udpate(Student student);

	public void delete(Integer id);

	public Student findById(Integer id);
}
