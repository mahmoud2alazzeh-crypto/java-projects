package oop;
import java.util.Scanner;
public class UserAcount extends Acount1 {

	private int pin;//private to use getters and setters to let it more private and cannot changed by anyone

	public UserAcount(double initialbalance, int maximumtransaction, int pin) {//new constructer in the class that extends the main class
		super(initialbalance, maximumtransaction);//super to call the other objects in the first const.
		this.pin = pin;
	}

	

	//encapsulation
	public int getpin() {//get the pin
		return pin;
	}

	public void setpin(int pin) {//set the pin 
		this.pin = pin;
	}

	public boolean validationpin(int usedpin) {
		return this.pin == usedpin;
	}
//overriding the deposit method to print another sentence
	public void deposit(int money) {
		System.out.println("deposit process");
		super.depositmoney(money);
		System.out.println("deposit process");
	}

	// this methods task is to start the atm
public void startatm() {//method task is to call the other methods by the user input and start the programme through it .
		Scanner input = new Scanner(System.in);

		System.out.println("please insert you pin : ");//can use try catch if the user enter a char instead of int.
		int usedpin = input.nextInt();
		if (validationpin(usedpin)) {

int choise = 0;
			do {
				printmenu();
				try {
				System.out.println("please enter your choise : ");
				choise = input.nextInt();
				}catch(java.util.InputMismatchException e) {
					System.out.println(e.getMessage());
					input.nextLine();
				}
				if (choise == 1) {
					System.out.println("the initial balance is : " + getbalance() + "JD");
				} else if (choise == 2) {
					System.out.println("please enter the deposit amount and note if want :");
					int money = input.nextInt();
					input.nextLine();//this line is used to clean the buffer
					System.out.println();
					System.out.println("do you want to add a note: (y,n) ");
					String yn = input.nextLine();
					if (yn.equalsIgnoreCase("y")) {
						System.out.println("please enter your note");
						String note = input.nextLine();
						this.depositmoney(money, note);
					} else {
						this.depositmoney(money);
					}
				} else if (choise == 3) {
					System.out.println("please enter the wethdraw amount : ");
					int money = input.nextInt();
					this.wethdrawmoney(money);
				} else if (choise == 4) {
					System.out.println("please enter the transaction amount to search ");
					int money = input.nextInt();
					int resualt = sentinalsearch(money);
					if (resualt != -1) {
						System.out.println("transaction amount " + money + " JD found at insex " + resualt);
					} else {
						System.out.println("transaction entered not found");
					}
				} else if (choise == 5) {//choose 5 to exit the loop and great you
					System.err.println("EXIT THE ATM");
					System.err.println("THANKS FOR CHOOSING US");
				} else {
					System.out.println("invalid input");
				}

			} while (choise != 5);//ends the loop if choise is 5

		}

		else {//print this message if the pas is incorrect
			System.out.println("cant access the atm , wrong pass");
		}

	}

	private void printmenu() {// menu to let the user go through the programme through it
		System.out.println("<<<<<<<<<<<<<< ATM MENU >>>>>>>>>>>>>>");
		System.out.println("1-showBalance");
		System.out.println("2-deposit and note");
		System.out.println("3-withdraw");
		System.out.println("4-search for sentinal");
		System.out.println("5-EXIT");
		System.out.println();
		System.out.println(
				"-----------------------------------------------------------------------------------------------");
	}

}
