package com.c174;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class EnterpriceCheckInSistemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriceCheckInSistemApplication.class, args);
	}

}
