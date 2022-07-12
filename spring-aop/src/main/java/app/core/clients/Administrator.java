package app.core.clients;

import org.springframework.stereotype.Component;

@Component
public class Administrator {

	public void greet() {
		System.out.println("Hello from admin");
	}

	public void addUser(int id) {
		System.out.println("adding user: " + id);
	}

	public void addManager() {
		System.out.println("adding manager");
	}

}
