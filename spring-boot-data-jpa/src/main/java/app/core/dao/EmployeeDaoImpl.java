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
		Employee empFromDb = em.find(Employee.class, employee.getId());
		if (empFromDb == null) {
			em.getTransaction().begin();
			try {
				// save the new employee
				em.persist(employee);
				em.getTransaction().commit();
				return employee.getId();
			} catch (Exception e) {
				em.getTransaction().rollback();
				throw new RuntimeException("create failed", e);
			}
		} else {
			throw new RuntimeException("create failed - already exist");
		}
	}

	@Override
	public Employee find(int id) {
		EntityManager em = factory.createEntityManager();
		return em.find(Employee.class, id);
	}

	@Override
	public void update(Employee employee) {
		EntityManager em = factory.createEntityManager();
		Employee empFromDb = em.find(Employee.class, employee.getId());
		if (empFromDb != null) {
			em.getTransaction().begin();
			try {
				// option 1: update selected fields:
//				empFromDb.setBirthdate(employee.getBirthdate());
//				empFromDb.setName(employee.getName());

				// option 2: update all fields
				employee = em.merge(employee);
				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("update failed - not found");
		}
	}

	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		Employee emp = em.find(Employee.class, id);
		if (emp != null) {
			em.getTransaction().begin();
			em.remove(emp);
			em.getTransaction().commit();
		} else {
			throw new RuntimeException("delete failed - not found");
		}
	}

}
