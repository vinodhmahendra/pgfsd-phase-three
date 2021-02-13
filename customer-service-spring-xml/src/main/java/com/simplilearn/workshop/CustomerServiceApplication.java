package com.simplilearn.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simplilearn.workshop.domain.Customer;
import com.simplilearn.workshop.services.CustomerService;

public class CustomerServiceApplication {

	public static void main(String[] args) {
		
		ApplicationContext springContainer = new ClassPathXmlApplicationContext("applicationContext.xml");


		CustomerService customerService = springContainer.getBean("customerService",CustomerService.class);
		
		// save a customer
		Customer create_customer = new Customer("prakash", "3741327647", "prakash@pivotal.io");
		customerService.createCustomer(create_customer);

		// find all customer
		List<Customer> customers = customerService.retreveAllCustomers();
		customers.forEach(customer -> System.out.println(customer.getId() + "\t" + customer.getName() + "\t"
				+ customer.getEmail() + "\t" + customer.getPhone()));

		// find customer by id
		String customer_id = customers.get(0).getId();
		Customer customer = customerService.retreveCustomerById(customer_id);
		System.out.println("*********find by id *********");
		System.out.println("customer name : " +customer.getName());
		
		

	}

}
