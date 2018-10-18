package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.CustomerDao;
import com.model.Customer;

@Service
public class CustomerService {
	
@Autowired	
private CustomerDao customerDao;

public void saveCustomer(Customer c) throws Exception {
	customerDao.registerUser(c);
	
}

public void updateCustomer(Customer c) throws Exception {
	
	customerDao.updateInformation(c);
	// TODO Auto-generated method stub
	
}

public Customer getCustomer(String emailId) {
	return customerDao.getCusometrInfo(emailId);
	
}

public List<Customer> getCustomers() {
	
	return customerDao.getCustomers();
	
}

}
