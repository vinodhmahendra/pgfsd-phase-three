package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;

@Service(value="customerService")
public class CustomerService {
	
	// depends on CustomerRepository
	private CustomerRepository customerRepository ;
	
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	// save a customer
	public void createCustomer(Customer customer) {
		//validate a customer
		customerRepository.saveCustomer(customer);
	}
	
	//find a customer with id
	public Customer retreveCustomerById(String id) {
		return customerRepository.findById(id);
	}
	
	// find all customers
	public List<Customer> retreveAllCustomers(){
		//authentication
		return customerRepository.findAll();
	}

}
