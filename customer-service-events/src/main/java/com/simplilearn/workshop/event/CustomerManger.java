package com.simplilearn.workshop.event;

import com.simplilearn.workshop.domain.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;

public interface CustomerManger {
	
	public Customer createNewCustomer();

}
