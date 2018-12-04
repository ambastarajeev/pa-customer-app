package com.plano.accounting.customer.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.plano.accounting.customer.entities.CustomerDetail;
import com.plano.accounting.customer.model.Customer;

@RunWith(SpringRunner.class)
public class CustomerDaoImplTests {

	@Mock
	CustomerDaoImpl customerDaoImpl;

	@Mock
	EntityManager entityManager;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getCustomersByTypeSuccess() {
		List<Customer> custList = new ArrayList<>();
		custList.add(new Customer(1, "a", 23, "abc@cb.com", "Indi"));
		custList.add(new Customer(2, "b", 33, "abc@cb.com", "Buis"));
		when(customerDaoImpl.getCustomersByType("Business")).thenReturn(custList);
		assertEquals(custList, customerDaoImpl.getCustomersByType("Business"));
	}
	
	@Test(expected = NullPointerException.class)
	public void getCustomerDetailByIdNullPointer() {
		assertEquals(3, customerDaoImpl.getCustomerDetailById(3).getCustomerId());
	}
	
	@Test
	public void mapToCustomerDetailSuccess() {
		customerDaoImpl = new CustomerDaoImpl();
		CustomerDetail result = customerDaoImpl.mapToCustomerDetail(new Customer(2, "a", 32, "a.c.v", "Indi"));
		assertEquals(32, result.getAge());
	}
	
	@Test
	public void mapToCustomerDetailAssertNull() {
		customerDaoImpl = new CustomerDaoImpl();
		CustomerDetail result = customerDaoImpl.mapToCustomerDetail(null);
		assertNull(result);
	}
	
	@Test
	public void mapToCustomerSuccess() {
		customerDaoImpl = new CustomerDaoImpl();
		Customer result = customerDaoImpl.mapToCustomer(new CustomerDetail(2, "a", 32, "a.c.v", "Indi"));
		assertEquals(2, result.getCustomerId());
	}
	
	@Test
	public void mapToCustomerAssertNull() {
		customerDaoImpl = new CustomerDaoImpl();
		Customer result = customerDaoImpl.mapToCustomer(null);
		assertNull(result);
	}
	
}
