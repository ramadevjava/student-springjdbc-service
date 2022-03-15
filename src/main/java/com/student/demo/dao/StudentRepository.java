package com.student.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.student.demo.bean.Student;

@Repository
public class StudentRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	  public List<Student> findAll() {
	    return jdbcTemplate.query("SELECT * from STUDENT", BeanPropertyRowMapper.newInstance(Student.class));
	  }
	  
	  public Student findById(Long id) {
	    try {
	      Student student = jdbcTemplate.queryForObject("SELECT * FROM STUDENT WHERE id=?",
	          BeanPropertyRowMapper.newInstance(Student.class), id);
	      return student;
	    } catch (DataAccessException e) {
	      return null;
	    }
	  }
	  
	  public int save(Student student) {
	    return jdbcTemplate.update("INSERT INTO STUDENT (student_name, student_class, join_date) VALUES(?,?,?)",
	        new Object[] { student.getStudentName(), student.getStudentClass(), student.getJoinDate() });
	  }

	  public int update(Student student) {
	    return jdbcTemplate.update("UPDATE STUDENT SET student_name=?, student_class=?, join_date=? WHERE id=?",
	        new Object[] { student.getStudentName(), student.getStudentClass(), student.getJoinDate(), student.getId() });
	  }

	  public int deleteById(Long id) {
	    return jdbcTemplate.update("DELETE FROM STUDENT WHERE id=?", id);
	  }


}
