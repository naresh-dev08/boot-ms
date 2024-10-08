package com.nt.ms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp-api")
public class EmployeeOperationsController {
	
	@GetMapping("/show")
	public ResponseEntity<String> showMessage() {
		return new ResponseEntity<String>("From the Employee Operations", HttpStatus.OK);
	}

}
