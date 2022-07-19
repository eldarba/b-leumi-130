package app.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.core.entities.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private EntityManagerFactory factory;

	@Override
	public int create(Employee employee) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin(); // start a transaction
			em.persist(employee); // employee is now persistent
			em.getTransaction().commit();
			return employee.getId();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public Employee find(int id) {
		EntityManager em = factory.createEntityManager();
		return em.find(Employee.class, id);
	}

}
