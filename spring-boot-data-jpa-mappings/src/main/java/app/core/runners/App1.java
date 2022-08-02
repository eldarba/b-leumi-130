package app.core.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Address;
import app.core.entities.School;
import app.core.services.MyService;

@Component
public class App1 implements CommandLineRunner {

	@Autowired
	private MyService service;

	@Override
	public void run(String... args) throws Exception {
		doCreateNewSchool();

	}

	void doCreateNewSchool() {

		Address address = new Address(0, 45, "Rothchild", "Jerusalem", "Israel", null);
		School school = new School(0, "JBT", address);
		service.createSchool(school);

	}

}
