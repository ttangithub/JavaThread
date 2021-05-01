package com.mytest.shareable;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	
	private double balance;
	private Lock balanceChangeLock;
	private Condition sufficientFundsCondition;
	
	public BankAccount() {
		
		balanceChangeLock = new ReentrantLock();
		sufficientFundsCondition = balanceChangeLock.newCondition();
		balance = 0;
		
	}
	
	public void deposit(double amount) {
		
		balanceChangeLock.lock();
		
		try {
			
			System.out.println("Depositing " + amount);
			double newBalance = balance + amount;
			System.out.println(", new balance is " + newBalance);
			balance = newBalance;
			sufficientFundsCondition.signalAll();
			
		} finally {
			
			balanceChangeLock.unlock();
			
		}
		
	}
	
	public void withdrawl(double amount) {

		balanceChangeLock.lock();
		
		try {
			
			while (balance < amount) {
				sufficientFundsCondition.await();
			}
			System.out.println("Withdrawing " + amount);
			double newBalance = balance - amount;
			System.out.println(", new balance is " + newBalance);
			balance = newBalance;
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		} finally {
			
			balanceChangeLock.unlock();
			
		}
		
	}
	
	public double getBalance() {
		
		return balance;
		
	}

}
