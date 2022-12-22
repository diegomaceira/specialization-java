package com.example.specializationjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages={"com.example.*"})
//@EnableJpaRepositories("com.example.*")
@EntityScan("com.example.*")
public class SpecializationJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpecializationJavaApplication.class, args);
	}

}
