package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.dao.EmployeeDAO;
import app.core.entities.Employee;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootDataJpaApplication.class, args);
		EmployeeDAO dao = ctx.getBean(EmployeeDAO.class);

		{// CREAT
//			Employee e = new Employee();
//			e.setName("Moshe");
//			e.setBirthdate(LocalDate.of(1990, 5, 11));
//			int id = dao.create(e);
//			System.out.println("id is " + id);
//			System.out.println("added: " + e);
		}

		{ // REAT
			Employee emp = dao.find(1);
			System.out.println(emp);
		}

	}

}
