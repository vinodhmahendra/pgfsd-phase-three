package com.simplilearn.workshop.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.domain.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;

@RestController
public class CustomerResource {

	@Autowired
	private CustomerRepository customerRepository;
	
	//@RequestMapping(value="/customers",method=RequestMethod.GET)
	@GetMapping("/customers")
	public List<Customer> retreveAllCustomers(){
		return customerRepository.findAll();
	}
	
	@PutMapping("/customers/{id}")
	public void updateCustomer(@PathVariable String id,@RequestBody Customer c){
		Customer customer = customerRepository.findById(id).orElse(null);
		if(customer != null){
			customer.setName(c.getName());
			customer.setPhone(c.getPhone());
			customer.setEmail(c.getEmail());
			customerRepository.save(customer);
		}
		
	}
	
	@GetMapping("/customers/{id}")
	public Customer retreveCustomer(@PathVariable String id){
		return customerRepository.findById(id).orElse(null);
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable String id){
		customerRepository.deleteById(id);
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer){
		Customer savedCustomer = customerRepository.save(customer);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedCustomer.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
