package com.student.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class StudentJDBCTemplateConfig {
	
	@Bean
	JdbcTemplate getJdbcTemplate(DataSource dataSource) {
	    JdbcTemplate jdbcTemplate = new JdbcTemplate();
	    jdbcTemplate.setDataSource(dataSource);
	    jdbcTemplate.setQueryTimeout(20); //20 seconds
	    jdbcTemplate.setFetchSize(10);  //fetch 10 rows at a time
	    return jdbcTemplate;
	}


}
