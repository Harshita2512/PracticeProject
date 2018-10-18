package com.db;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.Customer;


@Repository
public class CustomerDao {

	SessionFactory sf = DatabaseConn.getSessionFactory();


	public void registerUser (Customer c) throws Exception {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		session.save(c);
		t.commit();
		session.flush();
		session.close();
	}


	public Customer getCusometrInfo (String email)  {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Customer c = (Customer) session.get(Customer.class, email);
		session.close();

		return c;
	}

	
	public void updateInformation (Customer customer) throws Exception {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Customer c= (Customer) session.get(Customer.class, customer.getEmail());

		c.setPhoneNumber(customer.getPhoneNumber());
		c.setPassword(customer.getPassword());

		session.save(c);
		t.commit();
		session.flush();
		session.close();

	}

	public ArrayList<Customer> getCustomers ()  {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		ArrayList<Customer> customers =(ArrayList<Customer>) session.createCriteria(Customer.class).list();
		session.close();
		return customers;

	}


}





