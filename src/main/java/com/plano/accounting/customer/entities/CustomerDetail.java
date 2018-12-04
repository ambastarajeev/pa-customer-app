package com.plano.accounting.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "customer_detail")
@NamedQuery(name = "CustomerDetailFindByType", 
	query = "SELECT c FROM CustomerDetail c WHERE c.type =:type")
public class CustomerDetail {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "name", length=25)
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "email_id", length=25)
	private String emailId;
	
	@Column(name = "type", length=10)
	private String type;

	public CustomerDetail() {
		super();
	}

	public CustomerDetail(String name, int age, String emailId, String type) {
		super();
		this.name = name;
		this.age = age;
		this.emailId = emailId;
		this.type = type;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
