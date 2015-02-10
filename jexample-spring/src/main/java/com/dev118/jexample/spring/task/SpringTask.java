package com.dev118.jexample.spring.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringTask {

	@Scheduled(cron = "0/5 * * * * *")
	public void execute() {
		System.out.println("Spring.execute()...");
		System.out.println(System.currentTimeMillis());
	}
}
