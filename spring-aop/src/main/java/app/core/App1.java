package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.clients.Administrator;

public class App1 {

	public static void main(String[] args) {

		// create a spring container here
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);) {
			// start asking the container for beans
			Administrator admin = ctx.getBean(Administrator.class);
			admin.greet();
		}

	}

}
