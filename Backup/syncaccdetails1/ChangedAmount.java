package com.syncaccdetails;

public class ChangedAmount {

	int amount;


	public ChangedAmount( int amount){

		this.amount = amount;
		System.out.println("Amount"+amount);

	}


	public void deposit(int amount1)
	{
		amount+=amount1;
		System.out.println("Added "+amount);
		
	}
	public void deduct(int amount1)
	{
		amount-=amount1;
		System.out.println("Deducted "+amount);
		
		
	}


}
