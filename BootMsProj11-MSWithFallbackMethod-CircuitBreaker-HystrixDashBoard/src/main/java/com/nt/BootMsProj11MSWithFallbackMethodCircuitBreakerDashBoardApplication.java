package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class BootMsProj11MSWithFallbackMethodCircuitBreakerDashBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj11MSWithFallbackMethodCircuitBreakerDashBoardApplication.class, args);
	}

}
