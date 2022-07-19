package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		String msg = ctx.getBean("message", String.class);
		System.out.println(msg);

		int r = ctx.getBean("random", Integer.class);
		System.out.println(r);
	}

	@Bean
	public String message() {
		return "Hello";
	}

	@Bean
	public Integer random() {
		return (int) (Math.random() * 101);
	}

}
