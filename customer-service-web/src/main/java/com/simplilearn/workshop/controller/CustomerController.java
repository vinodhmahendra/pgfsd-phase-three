package com.simplilearn.workshop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.domain.Customer;
import com.simplilearn.workshop.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/")
	public ModelAndView home(){
		List<Customer> list_of_customers = customerService.retreveAllCustomerInfo();
		ModelAndView model = new ModelAndView("index");
		model.addObject("customers", list_of_customers);
		return model;// logical view name + model
	}
	
	@RequestMapping("/new")
	public String customerForm(Map<String, Object> model){ // display form
		Customer customer = new Customer();
		model.put("customer", customer);
		return "new_customer"; // logical view name
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String createCustomer(@ModelAttribute("customer") Customer customer){
		customerService.saveCustomer(customer);
		return "redirect:/"; // list of customer page
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomer(@RequestParam String id){
		ModelAndView modelAndView = new ModelAndView("edit_customer");
		Customer customer = customerService.retreveCustomerById(id);
		modelAndView.addObject("customer", customer);
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam String id){
		customerService.deleteCustomer(id);
		return "redirect:/";
	}
	
}
