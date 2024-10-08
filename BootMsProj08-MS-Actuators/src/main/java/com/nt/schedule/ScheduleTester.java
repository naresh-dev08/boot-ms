package com.nt.schedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTester {

	@Scheduled(cron = "0/15 * * * * *")
	public void showReport() {
		System.out.println("ScheduleTester.showReport()"+ new Date());
	}
}
