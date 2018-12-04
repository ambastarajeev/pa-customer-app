package com.plano.accounting.customer.service;

import java.util.List;
import com.plano.accounting.customer.model.Customer;

public interface CustomerService {
	
	int addCustomer(Customer customer);

	Customer getCustomerDetailById(int customerId);

	List<Customer> getCustomersByType(String customerType);
}
