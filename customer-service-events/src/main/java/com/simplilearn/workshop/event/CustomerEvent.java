package com.simplilearn.workshop.event;

import org.springframework.context.ApplicationEvent;

import com.simplilearn.workshop.domain.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;

//custom application event class
public class CustomerEvent extends ApplicationEvent {

	private String event_type;
	private Customer customer;

	public CustomerEvent(Object source, String event_type, Customer customer) {
		super(source);
		this.event_type = event_type;
		this.customer = customer;
	}

	public String getEvent_type() {
		return event_type;
	}

	public Customer getCustomer() {
		return customer;
	}
}
