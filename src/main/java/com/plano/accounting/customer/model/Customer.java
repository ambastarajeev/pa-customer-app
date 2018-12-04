package com.plano.accounting.customer.model;

public class Customer {
	private int customerId;
	private String name;
	private int age;
	private String emailId;
	private String type;
	public Customer() {
		super();
	}
	public Customer(int customerId, String name, int age, String emailId, String type) {
		super();
		this.customerId = customerId;
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
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", age=" + age + ", emailId=" + emailId
				+ ", type=" + type + "]";
	}
	
}
