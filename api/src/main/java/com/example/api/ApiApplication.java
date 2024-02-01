package com.example.api;

import com.example.db.item.EnableMoneyDiaryJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableMoneyDiaryJpaRepositories
@ComponentScan(basePackages = {"com.example.calculator", "com.example.db", "com.example.api"})
@EntityScan("com.example.db")
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
