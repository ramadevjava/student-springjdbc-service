package com.student.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.bean.Student;
import com.student.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentService.getStudents();
		if(ObjectUtils.isEmpty(students)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(students);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") Long id) {
		try {
		Student student = studentService.getStudentById(id);
		if(ObjectUtils.isEmpty(student)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(student);
		}	
		}catch(Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

/*	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable(name = "id") Long id) {
		return studentService.getStudentById(id);

	}
*/
	
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student) {

		int savedRecordId = studentService.saveStudent(student);

		return savedRecordId > 0 ? "Successfully added resource - " + savedRecordId : "unsuccessful";

	}

	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student) {

		int savedRecordId = studentService.updateStudent(student);

		return savedRecordId > 0 ? "Successfully updated resource - " + savedRecordId : "unsuccessful";

	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {

		int savedRecordId = studentService.deleteStudentById(id);

		return savedRecordId > 0 ? "Successfuly deleted resource - " + savedRecordId : "unsuccessful";

	}

}
