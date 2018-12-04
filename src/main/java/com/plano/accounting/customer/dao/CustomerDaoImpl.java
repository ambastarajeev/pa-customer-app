package com.plano.accounting.customer.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.plano.accounting.customer.entities.CustomerDetail;
import com.plano.accounting.customer.model.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public int addCustomer(Customer customer) {
		CustomerDetail customerDetail = mapToCustomerDetail(customer);
		entityManager.persist(customerDetail);
		return customerDetail.getCustomerId();
	}

	@Override
	public Customer getCustomerDetailById(int customerId) {
		return mapToCustomer(entityManager.find(CustomerDetail.class, customerId));
	}

	@Override
	public List<Customer> getCustomersByType(String type) {
		Query query = entityManager.createNamedQuery("CustomerDetailFindByType");
		query.setParameter("type", type);
		return mapToCustomerList((List<CustomerDetail>) query.getResultList());
	}
	
	private CustomerDetail mapToCustomerDetail(Customer customer) {
		return new CustomerDetail(customer.getName(), customer.getAge(), customer.getEmailId(), customer.getType());
	}
	
	private Customer mapToCustomer(CustomerDetail custDetail) {
		return new Customer(custDetail.getCustomerId(), custDetail.getName(), 
				custDetail.getAge(), custDetail.getEmailId(), custDetail.getType());
	}

	private List<Customer> mapToCustomerList(List<CustomerDetail> custDetailList){		
		return custDetailList.stream()
				.map(cd -> new Customer(cd.getCustomerId(), cd.getName(), cd.getAge(), cd.getEmailId(), cd.getType()))
                .collect(Collectors.toList());		
	}
}
