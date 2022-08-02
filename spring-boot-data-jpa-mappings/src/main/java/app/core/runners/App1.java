package app.core.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.entities.Address;
import app.core.entities.School;
import app.core.services.MyService;

// @Component
public class App1 implements CommandLineRunner {

	@Autowired
	private MyService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			// doCreateNewSchool();
			// doGetSchool(1);
			doUpdateSchoole();
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		}

	}

	void doUpdateSchoole() {
		School school = this.service.getSchoole(1);
		school.setName("The New School");
		school.getAddress().setCity("Haifa");
		service.updateSchool(school);
	}

	void doGetSchool(int id) {
		School school = this.service.getSchoole(id);
		System.out.println(school);
		System.out.println(school.getAddress());
	}

	void doCreateNewSchool() {
		Address address = new Address(0, 22, "Herzel", "Jerusalem", "Israel", null);
		School school = new School(0, "Arts", address, null, null);
		service.createSchool(school);
	}

}
