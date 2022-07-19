package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.dao.EmployeeDAO;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootDataJpaApplication.class, args);
		EmployeeDAO dao = ctx.getBean(EmployeeDAO.class);

//		{// CREAT
//			Employee e = new Employee();
//			e.setName("Eli");
//			e.setBirthdate(LocalDate.of(1995, 5, 11));
//			int id = dao.create(e);
//			System.out.println("id is " + id);
//			System.out.println("added: " + e);
//		}

//		{ // READ
//			Employee emp = dao.find(1);
//			System.out.println(emp);
//		}

		{// update
//			Employee e = new Employee(3, "Meir kohen", LocalDate.of(1995, 5, 11));
//			dao.update(e);
//			System.out.println("updated");
		}

		{ // delete
			dao.delete(2);
		}

	}

}
