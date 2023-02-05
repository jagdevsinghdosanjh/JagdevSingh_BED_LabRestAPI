package com.gl.studentdebate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.studentdebate.dao.StudentRepository;
import com.gl.studentdebate.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student udpate(Student student) {
		return studentRepo.save(student);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Student findById(Integer id) {
		return studentRepo.getById(id);
	}

	@Override
	public void delete(Integer id) {
		Student st = this.findById(id);
		studentRepo.delete(st);

	}

}
