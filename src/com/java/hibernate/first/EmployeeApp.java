package com.java.hibernate.first;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeApp {

	public static void main(String ...args){
		Session session=configuration();
		EmployeeRecord record=new EmployeeRecord();
		//record.saveEmployee(session);
		record.loadEmployee(session);
		session.close();
	}
	
	public static Session configuration(){
	Configuration configuration=new Configuration();
	configuration.configure("hibernate.cfg.xml");
	SessionFactory factory=configuration.buildSessionFactory();
	Session session=factory.openSession();
	return session;
	}
	
}