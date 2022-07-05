package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@Configuration
@PropertySource("application.properties")
public class SpringApp3 {

	public static void main(String[] args) throws InterruptedException {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApp3.class);) {
			String[] beans = ctx.getBeanDefinitionNames();
			for (String name : beans) {
				System.out.println(name);
			}
			Thread.sleep(3000);
		}

	}

}
