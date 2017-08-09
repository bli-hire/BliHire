package com.empatkepala;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	@Bean
	public CommandLineRunner loadData(CVRepository cvRepository) {
		return (args) -> {

			ArrayList<Brothers> dataBro = new ArrayList<>();
			Brothers bro = new Brothers("123","123","123","123");
			dataBro.add(bro);

			ArrayList<Children> dataChil = new ArrayList<>();
			Children chil = new Children("123","123","123","123");
			dataChil.add(chil);

			ArrayList<Language> dataLanguage = new ArrayList<>();
			//Language lang = new Language("123","123","123","123");
			//dataLanguage.add(lang);

			ArrayList<NonFormalCourse> dataNonformal = new ArrayList<>();
			NonFormalCourse nonForm = new NonFormalCourse("123","123",1,"123");
			dataNonformal.add(nonForm);

			ArrayList<School> dataSekolah = new ArrayList<>();
			School scho = new School("123","123","123","123",2.3);
			dataSekolah.add(scho);

			ArrayList<WorkExperience> dataExp = new ArrayList<>();
			WorkExperience we = new WorkExperience("123","123","123","123","123","123","123","123","123","123");
			dataExp.add(we);

			ArrayList<String> dataSIM = new ArrayList<>();
			dataSIM.add("A");
			dataSIM.add("B1");

			//cvRepository.save(new CV("123", "123", "123", "123", "123", dataSIM, "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123",dataBro,"13","123", "123", "123",dataChil, "123", "123", dataSekolah,"123", "123",dataNonformal, "123", "123", "123", "123", "123", 1996,"123",dataExp, "123", "123", "123", "123", "123", "123","123", "123", "123", "123", "123", "123", "123"));

		};
		}
}
