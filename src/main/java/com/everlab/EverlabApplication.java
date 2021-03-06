package com.everlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.everlab.test.HelloWorld;

@SpringBootApplication
public class EverlabApplication {

	public static void main(String[] args) {
		SpringApplication.run(EverlabApplication.class, args);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(EverLabConfiguration.class);

		HelloWorld hello = (HelloWorld) ctx.getBean(HelloWorld.class);
		hello.setMessage("set message");
		hello.getMessage();
	}
}
