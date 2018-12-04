package com.plano.accounting.customer.resource;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
public class CustomerResourceTests {
	
	@Mock
	CustomerResource customerResource;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getCustomerByIdSuccessResponse() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = "http://localhost:8081/customer/1";
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    Assert.assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void getCustomerByTypeSuccess() {
		assertEquals(0, customerResource.getCustomersByType("Business").size());
	}
}
