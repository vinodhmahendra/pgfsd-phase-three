package com.simplilearn.workshop;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.simplilearn.workshop.config.CustomerServiceConfig;
import com.simplilearn.workshop.domain.Customer;
import com.simplilearn.workshop.services.CustomerService;

public class CustomerServiceApplication {

	public static void main(String[] args) {
	
		ApplicationContext context = SpringApplication.run(CustomerServiceConfig.class);
		
		CustomerService customerService = context.getBean("customerService",CustomerService.class);
		
		Customer new_customer = new Customer("clarence", "222222", "clarence@pivotal.io");
		//customerService.saveCustomer(new_customer);
		customerService.deleteCustomer("402881e977c00d340177c00d46050000");
		
		System.out.println("the no of customers is  : " + customerService.retreveCustomerCount());
		
		
		System.out.println("Find all cusomers");
		List<Customer> load_all_customers = customerService.retreveAllCustomerInfo();
		for(Customer c : load_all_customers){
			System.out.println(c.getId() + "\t\t" +c.getName() + "\t\t" +c.getEmail()+"\t\t"+c.getPhone());
		}

		System.out.println("Find a customer by id : ");
		Customer c = customerService.retreveCustomerById("10001");
		
		System.out.println("update  a customer");
		c.setPhone("101010");
		
		System.out.println(c.getId() + "\t\t" +c.getName() + "\t\t" +c.getEmail()+"\t\t"+c.getPhone());
		
	
		customerService.updateCustomer(c);
		
	}

}
