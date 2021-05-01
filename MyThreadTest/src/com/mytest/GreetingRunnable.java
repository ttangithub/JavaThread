package com.mytest;

import java.util.Date;

public class GreetingRunnable implements Runnable {
	
	private String greeting;
	
	public GreetingRunnable(String aGreeting) {
		greeting = aGreeting;
	}

	@Override
	public void run() {
		
		try {
			
			for (int i=0; i<10; i++) {
				Date now = new Date();
				System.out.println(now + " " + greeting);
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {}
		
	}

}
