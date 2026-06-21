package procedural;

import java.util.Scanner;

public class Proceduralclass2 {

	static double balance = 1000; // the initial acount balance
	static int transactionhistory[] = new int[100]; // array to initialize hundred transactions
	static int numberoftransaction = 0; // to sum the number of transactions
	static final int authorizedpin = 12345; // the authorized pin to access the ATM

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);//scanner to take an input from the user
		System.out.println("welcome to ARAB BANK ATM");
		System.out.println("please enter your acount pin : ");
		int pass = input.nextInt();

		if (pass == authorizedpin) {//check if the pass is correct to cont the process
			int choise;
			do {
				printthemenu();
				System.out.println("enter your choise : ");

				choise = input.nextInt();
				if (choise == 1) {
					showbalance();
				} else if (choise == 2) {
					System.out.println("please enter the deposit amount : ");
					int money = input.nextInt();
					depositmoney(money);
				} else if (choise == 3) {
					System.out.println("please enter the wethdraw amount : ");
					int money = input.nextInt();
					wethdrawmoney(money);
				} else if (choise == 4) {
					System.out.println("please enter the transaction amount to search ");
					int money = input.nextInt();
					int resualt = sentinalsearch(transactionhistory, numberoftransaction, money);
					if (resualt != -1) {
						System.out.println("transaction amount " + money + " JD found at insex " + resualt);
					} else {
						System.out.println("transaction entered not found");
					}
				} else if (choise == 5) {
					System.err.println("EXIT THE ATM");
					System.err.println("THANKS FOR CHOOSING US");
				} else {
					System.out.println("invalid input");
				}
			} while (choise != 5);

		} else {
			System.out.println("sorry cannot acess incorrect pass");
		}

	}

	public static void printthemenu() {
		System.out.println("<<<<<<<<<<<<<< ATM MENU >>>>>>>>>>>>>>");
		System.out.println("1-showBalance");
		System.out.println("2-deposit");
		System.out.println("3-withdraw");
		System.out.println("4-search for sentinal");
		System.out.println("5-EXIT");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------");
	}
	// func. to show the initial balance for the user
	public static void showbalance() {
		System.out.println("your initial balance is : " + balance + " JD");
	}

	public static void depositmoney(int money) {
		if (money > 0) {
			System.out.println("Deposited : " + money + " JD");
			balance += money;
			recordtransaction(+money); //save the transaction for the record
			System.out.println("account balance after deposit : " + balance);
		} else {
			System.out.println("invalid deposit amounts");

		}
	}

	public static void wethdrawmoney(int money) {
		if (money > 0 && money <= balance) {
			balance -= money;
			recordtransaction(money);//save the transaction for the record
			System.out.println("amount of wethraw: " + money);
			System.out.println("balance after wethdraw is : " + balance);
		} else {
			System.out.println("canot complete the process(insufficient balance)");
		}

	}

	// func. saves the transaction history
	public static void recordtransaction(int money) {
		transactionhistory[numberoftransaction] = money;
		numberoftransaction++;
	}

	public static int sentinalsearch(int arr[], int x, int target) {// sentinal searching algo
if(numberoftransaction==0) {
	return -1;
}
		int lastelement = arr[x - 1];// save the last element
		arr[x - 1] = target;// make the target sentinel

		int i = 0;
		while (arr[i] != target) {// to continue the checks
			i++;
		}
		arr[x - 1] = lastelement;// restore the last element
		if (i < x - 1 || arr[x - 1] == target) {
			return i;// thats mean that the target is found
		} else {
			return -1;// thats mean that the target is not found
		}

	}

}
