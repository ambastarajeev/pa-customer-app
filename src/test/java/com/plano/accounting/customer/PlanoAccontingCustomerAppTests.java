package com.plano.accounting.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.plano.accounting.customer.dao.CustomerDaoImplTests;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerDaoImplTests.class)
public class PlanoAccontingCustomerAppTests {

	@Test
	public void contextLoads() {
	}

}
