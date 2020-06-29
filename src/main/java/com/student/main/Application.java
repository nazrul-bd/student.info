package com.student.main;

import com.student.main.Model.Student;
import com.student.main.Service.Service;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {



	@Autowired
	Service service ;
	@Autowired
	JdbcTemplate jdbcTemplate;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	InitializingBean sendDatabase() {
		return () -> {
  String sql = "create table 'studentinfo' (id int primary key, name varchar(20), department varchar(20), tutionfee int , birthdate date)";
			jdbcTemplate.update(sql);

		service.saveStudent( new Student(1, "hasan", "english", 600,
				new java.util.Date(System.currentTimeMillis())));

		};
	}




}
