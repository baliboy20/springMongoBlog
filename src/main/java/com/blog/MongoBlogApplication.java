package com.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blog.repos.BlogRepository;

@SpringBootApplication
public class MongoBlogApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MongoBlogApplication.class, args);
	}
}
