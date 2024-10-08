package com.nt.pms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingOperationsRestController {

	@Value("${server.port}")
	private int port;

	@Value("${eureka.instance.instance-id}")
	private String instanceID;

	@GetMapping("/billing")
	public ResponseEntity<String> showBillingInfo() {
		return new ResponseEntity<String>("We accept UPI payments, Debit cards, Credit cards and etc.. "
				+ " InstanceID " + instanceID + " Port:: " + port, HttpStatus.OK);
	}
}
