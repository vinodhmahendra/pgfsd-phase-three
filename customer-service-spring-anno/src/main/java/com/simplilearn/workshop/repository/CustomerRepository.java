package com.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.domain.Customer;


@Repository(value="customerRepository")
public class CustomerRepository {

	@SuppressWarnings("serial")
	private List<Customer> list_of_customers = new ArrayList<Customer>() {
		{
			add(new Customer("vinodh", "1234567890", "vinodh@pivotal.io"));
			add(new Customer("clarence", "2316242383", "clarence@pivotal.io"));
			add(new Customer("dennis", "0987654321", "dennis@pivotal.io"));
		}
	};

	public Customer saveCustomer(Customer customer) {
		assert customer.getName() != null;
		assert customer.getEmail() != null;
		assert customer.getPhone() != null;

		Customer _customer = new Customer(customer.getName(), customer.getPhone(), customer.getEmail());

		this.list_of_customers.add(_customer);
		return _customer;

	}

	public List<Customer> findAll() {
		return list_of_customers;
	}

	public Customer findById(String id) {
		Customer _customer = list_of_customers.stream().filter(customer -> customer.getId().equals(id)).findFirst()
				.orElse(null);
		return _customer;
	}

	// ADD updateCustmer method
}
