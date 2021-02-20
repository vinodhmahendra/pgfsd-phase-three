package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.domain.Customer;

public interface CustomerService {
	
	public long retreveCustomerCount();
	
	public List<Customer> retreveAllCustomerInfo();
	
	public Customer retreveCustomerById(String id);
	
	public Customer saveCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(String id);

}
