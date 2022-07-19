package app.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.dao.EmployeeDAO;
import app.core.entities.Employee;

// @Component
public class App1 implements CommandLineRunner {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public void run(String... args) throws Exception {

//		{// CREAT
//			Employee e = new Employee();
//			e.setName("Eli");
//			e.setBirthdate(LocalDate.of(1995, 5, 11));
//			int id = dao.create(e);
//			System.out.println("id is " + id);
//			System.out.println("added: " + e);
//		}

		{ // READ
			Employee emp = dao.find(1);
			System.out.println(emp);
		}

		{// update
//			Employee e = new Employee(3, "Meir kohen", LocalDate.of(1995, 5, 11));
//			dao.update(e);
//			System.out.println("updated");
		}

		{ // delete
//			dao.delete(2);
		}

	}

}
