package app.core.clients;

import org.springframework.stereotype.Component;

@Component
public class Customer {

	public void greet() {
		System.out.println("Hello from customer");
	}

	public void addCustomer() {
		System.out.println("adding customer");
	}

}
