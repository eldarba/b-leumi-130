package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.aspects.StatistcAspect;
import app.core.clients.Administrator;
import app.core.clients.Customer;
import app.core.clients.Manager;

public class App1 {

	public static void main(String[] args) {

		// create a spring container here
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);) {
			// start asking the container for beans
			Administrator admin = ctx.getBean(Administrator.class);
			Customer customer = ctx.getBean(Customer.class);

			admin.greet();
			customer.addCustomer();
			admin.addManager(new Manager());
			admin.greet();
			admin.addUser(5);
			customer.addCustomer();

			// getting data from the statistics aspect
			StatistcAspect statistcAspect = ctx.getBean(StatistcAspect.class);
			int addCalls = statistcAspect.getCounter();
			System.out.println("number of calls to add... is: " + addCalls);

		}

	}

}
