package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {

	public static void main(String[] args) {

		// create a spring container here
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);) {

		}

	}

}
