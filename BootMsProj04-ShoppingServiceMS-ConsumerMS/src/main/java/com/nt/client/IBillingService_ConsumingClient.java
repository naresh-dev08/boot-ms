package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("billing-service")
public interface IBillingService_ConsumingClient {
	
	@GetMapping("/billing-api/billing")
	public String getBillingInfo();

}
