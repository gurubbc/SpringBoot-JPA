package com.ofss.services;

import org.springframework.data.repository.CrudRepository;

import com.ofss.customer.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{

	
}
