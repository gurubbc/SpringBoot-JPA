package com.ofss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.customer.Customer;
import com.ofss.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService cs;
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
	public void addCustomer(@RequestBody Customer cust)
	{
		cs.addCustomer(cust);
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public List<Customer> getAllCustomers()
	{
		// implement
	}
	
	@RequestMapping(value="/customers/{name}", method=RequestMethod.GET)
	public Optional<Customer> getCustomer(@PathVariable("name") String firstName)
	{
		return cs.getCustomer(firstName);
	}

	@RequestMapping(value="/customers/update/{name}", method=RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customer cust, @PathVariable("name") String firstName)
	{
		cs.updateCustomer(firstName, cust);
		System.out.println("Updated successfully");
	}
	
	@RequestMapping(value="/customers/{name}", method=RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("name") String firstname)
	{
		cs.deleteCustomer(firstname);
	}
}
