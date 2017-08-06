package com.empatkepala;

import com.empatkepala.entity.CV;
import com.empatkepala.entity.CVEntity.*;
import com.empatkepala.repository.CVRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class BliHireApplication {

	public static void main(String[] args) {
		SpringApplication.run(BliHireApplication.class, args);
	}
}
