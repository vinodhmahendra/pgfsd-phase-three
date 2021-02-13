package com.simplilearn.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simplilearn.workshop.repository.CustomerRepository;
import com.simplilearn.workshop.services.CustomerService;

@Configuration
public class CustomerServiceConfig {

	@Bean(name="customerRepository")
	public CustomerRepository customerRepository() {
		return new CustomerRepository();
	}
	
	@Bean(name="customerService")
	public CustomerService customerService() {
		CustomerService customerService = new CustomerService();
		customerService.setCustomerRepository(customerRepository());
		return customerService;
	}
}
