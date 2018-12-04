package com.plano.accounting.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plano.accounting.customer.dao.CustomerDao;
import com.plano.accounting.customer.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer getCustomerDetailById(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomersByType(String customerType) {
		// TODO Auto-generated method stub
		return null;
	}

}
