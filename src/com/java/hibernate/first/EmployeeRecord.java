package com.java.hibernate.first;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeRecord {

	public void saveEmployee(Session session){
		Transaction transaction=session.beginTransaction();
		Employee employee=new Employee();
		employee.setName("Aakash");
		employee.setSalay(10000);
		session.save(employee);
		transaction.commit();
		System.out.println("Data Saved");
	}
	
	public void loadEmployee(Session session){
		//Fetching Entity from Database
		Employee employee=(Employee)session.load(Employee.class,new Integer(42));
		System.out.println(employee.getName());
		System.out.println(session.getSessionFactory().getStatistics().getEntityFetchCount());
		//session.evict(employee);
		
		//Fetching Entity from First Level cache
		Employee employee1=(Employee)session.load(Employee.class,new Integer(42));
		System.out.println(employee1.getName());
		System.out.println(session.getSessionFactory().getStatistics().getEntityFetchCount());
	}
}