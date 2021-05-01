package com.mytest.shareable;

public class DepositRunnable implements Runnable {
	
	private static final int DELAY = 1;
	private BankAccount account;
	private double amount;
	private int count;
	
	public DepositRunnable(BankAccount anAccount, double anAmount, int aCount)
	{
		account = anAccount;
		amount = anAmount;
		count = aCount;
	}

	@Override
	public void run() {
		try
		{
			for (int i = 1; i <= count; i++)
			{
				account.deposit(amount);
				Thread.sleep(DELAY);
			}
		}
		catch (InterruptedException exception) {}		
	}
	
}
