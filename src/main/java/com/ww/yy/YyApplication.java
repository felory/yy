package com.ww.yy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class YyApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(YyApplication.class, args);
	}
//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO users (name, password) VALUES (?, ?, ?)";
//
//		int result = jdbcTemplate.update(sql, "Ravi Kumar", "ravi.kumar@gmail.com", "ravi2021");
//
//		if (result > 0) {
//			System.out.println("A new row has been inserted.");
//		}
//
//	}


}
