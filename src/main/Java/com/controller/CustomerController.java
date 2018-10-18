package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Service.CustomerService;
import com.model.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customers" , method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity createCustomer(@RequestBody Customer c) {
		ResponseEntity entity ;
		
		if(c != null) {
			try {
				customerService.saveCustomer(c);
				entity =  new ResponseEntity(HttpStatus.CREATED);
			} catch (Exception e) {
				entity =  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			entity =  new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	@RequestMapping(value = "/customers/{emailId}" , method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity updateCustomer(@PathVariable String emailId, @RequestBody Customer c) {
		ResponseEntity entity ;
			
		if(c != null && emailId.equals(c.getEmail())) {
			try {
				customerService.updateCustomer(c);
				entity =  new ResponseEntity(HttpStatus.CREATED);
			} catch (Exception e) {
				entity =  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			entity =  new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	
		return entity;
	}

	@RequestMapping(value = "/customers/{emailId}" , method = RequestMethod.GET, produces="application/json")
	public ResponseEntity getCustomer(@PathVariable String emailId) {
		ResponseEntity entity ;
		
		if(emailId != null ){
			try {
				Customer c = customerService.getCustomer(emailId);
				entity =  new ResponseEntity(c, HttpStatus.OK);
			} catch (Exception e) {
				entity =  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			entity =  new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	@RequestMapping(value = "/customers" , method = RequestMethod.GET, produces="application/json")
	public ResponseEntity getCustomer() {
		ResponseEntity entity ;
		
		
			try {
				List<Customer> c = customerService.getCustomers();
				entity =  new ResponseEntity(c, HttpStatus.OK);
			} catch (Exception e) {
				entity =  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		 
		
		return entity;
	}

}
