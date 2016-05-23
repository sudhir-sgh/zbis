package com.zopper.bsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by sudhir on 18/5/16.
 */
@Configuration
@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = { "com.zopper.bsi*" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
