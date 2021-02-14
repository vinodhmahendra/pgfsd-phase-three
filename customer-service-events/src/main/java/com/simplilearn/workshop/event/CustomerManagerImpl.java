package com.simplilearn.workshop.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;

@Service(value = "customerManager")
public class CustomerManagerImpl implements CustomerManger, ApplicationEventPublisherAware {

	@Autowired
	private CustomerRepository customerRepository;

	private ApplicationEventPublisher eventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("set application event publisher method invoked");
		this.eventPublisher = applicationEventPublisher;
	}

	@Override
	public Customer createNewCustomer() {
		
		Customer customer = customerRepository.saveCustomer(new Customer("abu", "0273174", "abu@pivotal.com"));
		
		//publishing the event
		eventPublisher.publishEvent(new CustomerEvent(this, "CREATE", customer));
		
		return customer;
	}

}
