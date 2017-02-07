package com.everlab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.everlab.test.HelloWorld;

@Configuration
public class EverLabConfiguration {

	@Bean(initMethod = "init")
	@Scope("singleton")
	public EverLabUtils EverLabUtils() {
		return new EverLabUtils();
	}

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public HelloWorld HelloWorld() {
		HelloWorld hello = new HelloWorld();
		hello.setMessage("Hello: ");
		return hello;
	}
}
