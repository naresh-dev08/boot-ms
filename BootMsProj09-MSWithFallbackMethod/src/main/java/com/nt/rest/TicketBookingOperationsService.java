package com.nt.rest;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ticket")
public class TicketBookingOperationsService {
	
	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummyBookTicket")
	public ResponseEntity<String> bookTickets() {
		System.out.println("TicketBookingOperationsService.bookTickets()----b.Method()");
		int numInt = new Random().nextInt(10);
		if(numInt<5) {
			throw new RuntimeException("Problem in b.method of ticket booking ");
		}
		return new ResponseEntity<String>("Ticket booked successfully "+numInt, HttpStatus.OK);
	}//bookTickets()
	
	public ResponseEntity<String> dummyBookTicket() {
		System.out.println("TicketBookingOperationsService.dummyBookTicket()");
		return new ResponseEntity<String>("Problem in ticket booking,...inconvience is regrated...", HttpStatus.TOO_MANY_REQUESTS);
	}

}
