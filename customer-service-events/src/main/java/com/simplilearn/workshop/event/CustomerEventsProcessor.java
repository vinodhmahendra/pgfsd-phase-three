package com.simplilearn.workshop.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerEventsProcessor implements ApplicationListener<CustomerEvent> {

	@Override
	public void onApplicationEvent(CustomerEvent event) {
		
		CustomerEvent customerEvent = event;
		
		System.out.println(" Customer " +customerEvent.getEvent_type() + " with details " +customerEvent.getCustomer());
		
		// do more processing as per application logic
		
	}

}
