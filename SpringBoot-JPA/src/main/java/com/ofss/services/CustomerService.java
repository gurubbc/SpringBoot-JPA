package com.ofss.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.customer.Customer;


public class CustomerService {

	
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers()
	{
		System.out.println("Returning all customers using Customer Repository");
		List<Customer> allCustomers=new ArrayList<>();
		customerRepository.findAll()
		.forEach(customer -> allCustomers.add(customer));
		return allCustomers;
	}
	
	public Optional<Customer> getCustomer(String name)
	{
		return customerRepository.findById(name);
	}
	
	public void addCustomer(Customer cust)
	{
		System.out.println("Adding customer using Customer Repository");
		customerRepository.save(cust);
	}

	public void updateCustomer(String customerName, Customer cust) {
		System.out.println("Updating customer using Customer Repository "+customerName);
		Optional<Customer> customerToUpdate = customerRepository.findById(customerName);
		Customer custTemp=customerToUpdate.get();
		custTemp.setPhoneNumber(cust.getPhoneNumber());
	}
	
	public void deleteCustomer(String customerName) {
		System.out.println("Deleting customer using Customer Repository  using name"+customerName);
		customerRepository.deleteById(customerName);
	}

	
}
