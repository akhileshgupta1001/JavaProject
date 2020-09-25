package com.akhilesh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.akhilesh.entity.Employee;

public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employee = query.getResultList();
		return employee;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
