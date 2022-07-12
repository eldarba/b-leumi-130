package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Calculator;

public class App1 {

	public static void main(String[] args) {

		// create a spring container here
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);) {

			Calculator calculator = ctx.getBean(Calculator.class);
			int a = 25;
			int b = 0;

			String res = calculator.divide(a, b);

			System.out.println(res);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
