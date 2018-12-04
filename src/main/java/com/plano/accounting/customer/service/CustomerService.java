package com.plano.accounting.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plano.accounting.customer.dao.CustomerDao;
import com.plano.accounting.customer.model.Customer;

@RestController
@RequestMapping(path = "/customer")
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;

	@GetMapping(path="/{id}", produces = "application/json")
	public Customer getCustomerById(@PathVariable("id") int customerId)
	{
		System.out.println("customerId: " + customerId);
		Customer customerInfo = customerDao.getCustomerDetailById(customerId);
		return customerInfo;
	}
	
	@GetMapping(path="/list", produces = "application/json")
	public List<Customer> getCustomersByType(@RequestParam("type") String type)
	{
		System.out.println("type: " + type);
		List<Customer> custmersList = customerDao.getCustomersByType(type);
		return custmersList;
	}
	
	@PostMapping(path="/add", produces = "application/json", consumes = "application/json")
	public String addCustomer(@RequestBody Customer customer)
	{
		System.out.println("customer: " + customer);
		int customerId = customerDao.addCustomer(customer); 
		System.out.println("customerId: " + customerId);
		return "Successful registration. Id: " + customerId;
	}
}
