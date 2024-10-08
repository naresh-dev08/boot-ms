package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingService_ConsumingClient {

	@Autowired
	private DiscoveryClient client;
	
	public String getBillingInfo() {
		//get prover ms
		List<ServiceInstance> list = client.getInstances("billing-service");
		//get the first instance
		ServiceInstance si = list.get(0);
		//get URI from provider ms
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
