package com.nt.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingService_ConsumingClient {

	@Autowired
	private LoadBalancerClient client;
	
	public String getBillingInfo() {
		//get the Billing-Service Instance from eureka server based on LoadFactor
		ServiceInstance si = client.choose("Billing-Service");
		//Get details from service instance
		URI uri = si.getUri();
		//prepare the URL from URI pointing B.method of the provider MS
		String URL = uri.toString()+"/billing-api/billing";
		//invoke the provider ms b.method using RestTemple
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
		String result = responseEntity.getBody();
		return result;
	}
}
