package com.simplilearn.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public long retreveCustomerCount() {
		return customerRepository.count();
	}

	@Override
	public List<Customer> retreveAllCustomerInfo() {
		return customerRepository.findAll();
	}

	@Override
	public Customer retreveCustomerById(String id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		return customer;
	}

	@Override
	public Customer saveCustomer(Customer customer) {		
		return customerRepository.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		
		Optional<Customer> _customer = customerRepository.findById(customer.getId());
		if(_customer.isPresent()){
			Customer update_customer = _customer.get();
			update_customer.setPhone(customer.getPhone());
			update_customer.setEmail(customer.getEmail());
			customerRepository.save(update_customer); // automatically do update
		}
		
	}

	@Override
	public void deleteCustomer(String id) {
		customerRepository.deleteById(id);
	}
}
