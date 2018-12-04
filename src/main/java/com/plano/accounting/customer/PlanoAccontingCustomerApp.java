package com.plano.accounting.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.plano.accounting.customer")
public class PlanoAccontingCustomerApp {
		
	public static void main(String[] args) {
		SpringApplication.run(PlanoAccontingCustomerApp.class, args);
	}	
}
