package com.nt.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BillingService_ConsumingClient {

	@Autowired
	private LoadBalancerClient client;
	
	public String getBillingInfo() {
		log.info("start of the getBillingInfo method----ShoppingServiceMs");
		//get the Billing-Service Instance from eureka server based on LoadFactor
		ServiceInstance si = client.choose("Billing-Service");
		log.info("getting the MS instance----ShoppingServiceMs");
		//Get details from service instance
		URI uri = si.getUri();
		log.info("getting the MS URI----ShoppingServiceMs");
		//prepare the URL from URI pointing B.method of the provider MS
		String URL = uri.toString()+"/billing-api/billing";
		log.info("getting the MS URL----ShoppingServiceMs");
		//invoke the provider ms b.method using RestTemple
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
		log.info("Invoking the destination MS----ShoppingServiceMs");
		String result = responseEntity.getBody();
		return result;
	}
}
