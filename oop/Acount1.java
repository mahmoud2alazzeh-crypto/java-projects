package oop;

import java.util.Scanner;

public class Acount1 {

	private double balance;
	private int transactionhistory[];
	private int numtransaction;

	public Acount1(double initialbalance, int maximumtransaction) {
		this.balance = initialbalance;
		this.transactionhistory = new int[maximumtransaction];
		this.numtransaction = 0;
	}

	
	public double getbalance() {
		return balance;
	}

	public void setbalance(double balance) {
		this.balance = balance;
	}

	public void depositmoney(int money) {
		if (money > 0) {
			System.out.println("Deposited : " + money + " JD");
			balance += money;
			recordtransaction(money); // save the transaction for the record
			System.out.println("account balance after deposit : " + balance);
		} else {
			System.out.println("invalid deposit amounts");

		}
	}
	
	public void depositmoney(int money, String note) {//overload the deposit method to let the user add a note
		if (money > 0) {
			System.out.println("Deposited : " + money + " JD");
			balance += money;
			recordtransaction(money); // save the transaction for the record
			System.out.println("account balance after deposit : " + balance+"|| the note is : "+note );
		} else {
			System.out.println("invalid deposit amounts");

		}
	}
	

	public void wethdrawmoney(int money) {
		if (money > 0 && money <= balance) {
			balance -= money;
			recordtransaction(money);// save the transaction for the record
			System.out.println("amount of wethraw: " + money);
			System.out.println("balance after wethdraw is : " + balance);
		} else {
			System.out.println("canot complete the process(insufficient balance)");
		}

	}

	// func. saves the transaction history
	public void recordtransaction(int money) {
		if (numtransaction < transactionhistory.length) {
			transactionhistory[numtransaction] = money;
			numtransaction++;
		} else {
			System.out.println("the transaction hets the max number");
		}
	}
	
	public  int sentinalsearch( int target) {// sentinal searching algo
		
		if(numtransaction==0) {
			return -1;
		}
		
		int lastelement = transactionhistory[numtransaction- 1];// save the last element
		transactionhistory[numtransaction- 1] = target;// make the target sentinel

		int i = 0;
		while (transactionhistory[i] != target) {// to continue the checks
			i++;
		}
		transactionhistory[numtransaction - 1] = lastelement;// restore the last element
		if (i < numtransaction - 1 || transactionhistory[numtransaction - 1] == target) {
			return i;// thats mean that the target is found
		} else {
			return -1;// thats mean that the target is not found
		}

	}

}
