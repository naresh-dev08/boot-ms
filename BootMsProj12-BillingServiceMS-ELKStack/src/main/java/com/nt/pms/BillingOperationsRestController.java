package com.nt.pms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/billing-api")
@Slf4j
public class BillingOperationsRestController {
	
	@Value("${server.port}")
	private int port;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceID;

	@GetMapping("/billing")
	public ResponseEntity<String> showBillingInfo() {
		log.info("BiilingMS:: showBillingInfo Method");
		return new ResponseEntity<String>("We accept UPI payments, Debit cards, Credit cards and etc.. " + instanceID + " " + port, HttpStatus.OK);
	}
}
