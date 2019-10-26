package com.codve.read;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 * 可以 gradle bootRun 启动
 * 也可以 gradle build, cd build/libs, java -jar app.jar
 */
@SpringBootApplication
public class ReadApplication{

	public static void main(String[] args) {
		SpringApplication.run(ReadApplication.class, args);
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/readingList");
	}

}
