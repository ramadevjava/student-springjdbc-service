package com.student.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.demo.bean.Student;

public class StudentRowMapper implements RowMapper{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setStudentName(rs.getString("student_name"));
		student.setStudentClass(rs.getString("student_class"));
		student.setJoinDate(rs.getDate("join_date"));
		
		return student;
	}
}
