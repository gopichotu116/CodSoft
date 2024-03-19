package com.codesoft;

import java.util.Scanner;

public class AtmInterface {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BankAccount userAccount = new BankAccount(1500);
		ATM atm = new ATM(userAccount);
		System.out.println("Enter Your ATM PIN");
		String pin = scn.nextLine();
		if (pin.equals("9876")) {
			atm.run();
		} else {
			System.out.println("Wrong ATM Pin try again....!");
		}
	}
}

class BankAccount {

	private int bal;

	public BankAccount(int initialAmount) {
		this.bal += initialAmount;
	}

	public int balance() {
		return bal;
	}

	public void deposit(int amt) {
		if (amt > 0) {
			bal += amt;
			System.out.println("Deposit of Rs" + amt + " was successfully completed");
		} else {
			System.out.println("Invalid entry!.... Please choose a number above Zero(0)");
		}
	}

	public void withdraw(int amt) {
		if (amt > 0 && amt <= bal) {
			System.out.println("Withdraw successfully completed of Rs" + amt);
			bal -= amt;

		} else {
			System.out.println("Invaid entry....!, insuffucient balance or negative value entered");
		}
	}
}

class ATM {

	private BankAccount account;

	public ATM(BankAccount account) {
		this.account = account;
	}

	int i = 0;

	public void display() {

		if (i > 0) {
			System.out.println();
		}
		System.out.println("Select Options");
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Check Balance");
		System.out.println("4. Exit");
	}

	public void run() {
		Scanner scn = new Scanner(System.in);
		int option = 0;
		while (option != 4) {
			display();
			System.out.println("Pick an option");
			option = scn.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter amount to deposit");
				int depositAmount = scn.nextInt();
				i++;
				account.deposit(depositAmount);
				break;
			case 2:
				System.out.println("Enter amount to withdraw");
				int withdrawAmount = scn.nextInt();
				i++;
				account.withdraw(withdrawAmount);
				break;
			case 3:
				System.out.println("Current balance " + account.balance());
				i++;
				break;
			case 4:
				System.out.println("Thanks for using our ATM... Kotak Mahindra Bank");
				scn.close();
				break;
			default:
				System.out.println("Invalid entry!!. Enter only the given options");
			}
		}
	}
}
