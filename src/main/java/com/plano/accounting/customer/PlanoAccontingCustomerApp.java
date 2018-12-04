package com.plano.accounting.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.plano.accounting.customer")
public class PlanoAccontingCustomerApp {
		
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PlanoAccontingCustomerApp.class, args);
	}	
}
