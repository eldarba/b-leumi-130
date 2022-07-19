package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.UsersAdministrator;

public class App2 {

	public static void main(String[] args) {

		// create a spring container here
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);) {

			UsersAdministrator admin = ctx.getBean(UsersAdministrator.class);
			admin.addUser();
			admin.blockUser();
			admin.removeUser();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
