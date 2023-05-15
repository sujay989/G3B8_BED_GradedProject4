package com.greatlearning.empmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class EmployeeMgmtRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMgmtRestApiApplication.class, args);
	}

}
