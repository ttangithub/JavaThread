package com.mytest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestGreeting {

	public static void main(String[] args) {
		
		GreetingRunnable r1 = new GreetingRunnable("Hello");
		GreetingRunnable r2 = new GreetingRunnable("GoodBye");
		
//		Thread t1 = new Thread(r1);
//		Thread t2 = new Thread(r2);
//		t1.start();
//		t2.start();
		
		ExecutorService pool = Executors.newFixedThreadPool(5);
		
		pool.execute(r1);
		pool.execute(r2);
		
		

	}

}
