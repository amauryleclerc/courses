package fr.aleclerc.courses;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class CoursesApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CoursesApplication.class);
	}

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(CoursesApplication.class, args);
		new CoursesApplication()
		.configure(new SpringApplicationBuilder(CoursesApplication.class))
		.run(args);
	}

}