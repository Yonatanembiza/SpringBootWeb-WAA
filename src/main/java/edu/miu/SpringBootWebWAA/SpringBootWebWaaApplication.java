package edu.miu.SpringBootWebWAA;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EntityScan(basePackages = {"edu.miu.SpringBootWebWAA.entity"})
public class SpringBootWebWaaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootWebWaaApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
