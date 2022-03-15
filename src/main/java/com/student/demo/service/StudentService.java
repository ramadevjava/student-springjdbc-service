package com.student.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.bean.Student;
import com.student.demo.dao.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
		
	}
	
	public Student getStudentById(Long id) {
		return studentRepository.findById(id);
		
	}
	
	public int saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public int updateStudent(Student student) {
		return studentRepository.update(student);
	}
	
	public int deleteStudentById(Long id) {
		
		return studentRepository.deleteById(id);
		
	}

}
