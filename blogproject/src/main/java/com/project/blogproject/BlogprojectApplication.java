package com.project.blogproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BlogprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogprojectApplication.class, args);
	}
	@LoadBalanced
	@Bean
	public RestTemplate myrestTemplate(){
		return new RestTemplate();
	}

}
