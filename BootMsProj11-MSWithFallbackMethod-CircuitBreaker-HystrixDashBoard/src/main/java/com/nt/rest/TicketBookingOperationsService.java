package com.nt.rest;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket")
public class TicketBookingOperationsService {
	
	int count = 0;
	
//	@GetMapping("/book")
//	@HystrixCommand(fallbackMethod = "dummyBookTicket",
//	commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled", value = "true")})
//	public ResponseEntity<String> bookTickets() {
//		System.out.println("TicketBookingOperationsService.bookTickets()----b.Method()");
//		if(new Random().nextInt(10) < 9) {
//			throw new RuntimeException("Problem in b.method of ticket booking ");
//		}
//		return new ResponseEntity<String>("Ticket booked successfully ", HttpStatus.OK);
//	}//bookTickets()
	
	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummyBookTicket",
	commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
			             @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			             @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5")})
	public ResponseEntity<String> bookTickets() {
		System.out.println("TicketBookingOperationsService.bookTickets()----b.Method()");
		if(new Random().nextInt(10) < 8) {
			throw new RuntimeException("Problem in b.method of ticket booking ");
		}
		return new ResponseEntity<String>("Ticket booked successfully", HttpStatus.OK);
	}//bookTickets()
	
	public ResponseEntity<String> dummyBookTicket() {
		System.out.println("TicketBookingOperationsService.dummyBookTicket()" + (++count));
		return new ResponseEntity<String>("Problem in ticket booking,...inconvience is regrated..." + count, HttpStatus.TOO_MANY_REQUESTS);
	}//dummyBookTicket()

}
