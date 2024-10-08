package com.nt.cms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingService_ConsumingClient;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceOperationsController {

	@Autowired
	private IBillingService_ConsumingClient clientComp;

	@Value("${server.port}")
	private int port;

	@Value("${eureka.instance.instance-id}")
	private String instanceID;

	@GetMapping("/info")
	public ResponseEntity<String> getShoppingInfo() {
		// use the provider ms
		String billingInfo = clientComp.getBillingInfo();
		// get the Shopping MS results
		String shoppingInfo = "The Shopping bill amount is " + new Random().nextInt(20000) +" instanceID:: "+ instanceID + " Port Num:: " + port;
		// combine the final result
		String finalResult = shoppingInfo + "--" + billingInfo;
		return new ResponseEntity<String>(finalResult, HttpStatus.OK);
	}
}
