package com.empatkepala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;


@SpringBootApplication
public class BliHireApplication {

	public static void main(String[] args){
		SpringApplication.run(BliHireApplication.class, args);
	}
}
