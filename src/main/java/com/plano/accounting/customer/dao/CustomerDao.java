package com.plano.accounting.customer.dao;

import java.util.List;
import com.plano.accounting.customer.model.Customer;

public interface CustomerDao {
	
	int addCustomer(Customer customer);
	
	Customer getCustomerDetailById(int customerId);
	
	List<Customer> getCustomersByType(String customerType);

}
