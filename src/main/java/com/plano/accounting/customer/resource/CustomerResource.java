package com.plano.accounting.customer.resource;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class CustomerResource {
	
	private static final Logger logger = LogManager.getLogger(CustomerResource.class);
	
	@Autowired
	CustomerDao customerDao;

	@GetMapping(path="/{id}", produces = "application/json")
	public Customer getCustomerById(@PathVariable("id") int customerId)
	{
		logger.info("Entering getCustomerById");
		logger.debug("customerId: " + customerId);
		Customer customerInfo = customerDao.getCustomerDetailById(customerId);
		return customerInfo;
	}
	
	@GetMapping(path="/list", produces = "application/json")
	public List<Customer> getCustomersByType(@RequestParam("type") String type)
	{
		logger.info("Entering getCustomersByType");
		logger.debug("type: " + type);
		List<Customer> custmersList = customerDao.getCustomersByType(type);
		return custmersList;
	}
	
	@PostMapping(path="/add", produces = "application/json", consumes = "application/json")
	public String addCustomer(@RequestBody Customer customer)
	{
		logger.info("Entering addCustomer");
		logger.debug("Add customer: " + customer);
		int customerId = customerDao.addCustomer(customer); 
		logger.debug("Generated customerId: " + customerId);
		return "Successful registration. Id: " + customerId;
	}
}
