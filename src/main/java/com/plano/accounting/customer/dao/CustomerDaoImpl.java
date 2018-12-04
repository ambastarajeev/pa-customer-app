package com.plano.accounting.customer.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.plano.accounting.customer.entities.CustomerDetail;
import com.plano.accounting.customer.model.Customer;
import com.plano.accounting.customer.resource.CustomerResource;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(CustomerDaoImpl.class);
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.plano.accounting.customer.dao.CustomerDao#addCustomer(com.plano.accounting.customer.model.Customer)
	 */
	@Override
	public int addCustomer(Customer customer) {
		logger.info("Entering addCustomer");
		CustomerDetail customerDetail = mapToCustomerDetail(customer);
		entityManager.persist(customerDetail);
		return customerDetail.getCustomerId();
	}

	/* (non-Javadoc)
	 * @see com.plano.accounting.customer.dao.CustomerDao#getCustomerDetailById(int)
	 */
	@Override
	public Customer getCustomerDetailById(int customerId) {
		logger.info("Entering getCustomerDetailById");
		return mapToCustomer(entityManager.find(CustomerDetail.class, customerId));
	}

	/* (non-Javadoc)
	 * @see com.plano.accounting.customer.dao.CustomerDao#getCustomersByType(java.lang.String)
	 */
	@Override
	public List<Customer> getCustomersByType(String type) {
		logger.info("Entering getCustomersByType");
		Query query = entityManager.createNamedQuery("CustomerDetailFindByType");
		query.setParameter("type", type);
		return mapToCustomerList((List<CustomerDetail>) query.getResultList());
	}

	/**
	 * Map to customer detail.
	 *
	 * @param customer the customer
	 * @return the customer detail
	 */
	public CustomerDetail mapToCustomerDetail(Customer customer) {
		logger.info("Entering mapToCustomerDetail");
		if(customer != null) {
			return new CustomerDetail(customer.getName(), customer.getAge(), customer.getEmailId(), customer.getType());
		}
		return null;
	}

	/**
	 * Map to customer.
	 *
	 * @param custDetail the cust detail
	 * @return the customer
	 */
	public Customer mapToCustomer(CustomerDetail custDetail) {
		logger.info("Entering mapToCustomer");
		if(custDetail != null) {
			return new Customer(custDetail.getCustomerId(), custDetail.getName(), 
					custDetail.getAge(), custDetail.getEmailId(), custDetail.getType());
		}
		return null;
	}

	/**
	 * Map to customer list.
	 *
	 * @param custDetailList the cust detail list
	 * @return the list
	 */
	public List<Customer> mapToCustomerList(List<CustomerDetail> custDetailList){	
		logger.info("Entering mapToCustomerList");
		if(custDetailList != null) {
			return custDetailList.stream()
					.map(cd -> new Customer(cd.getCustomerId(), cd.getName(), cd.getAge(), cd.getEmailId(), cd.getType()))
					.collect(Collectors.toList());	
		}
		return null;
	}
}
