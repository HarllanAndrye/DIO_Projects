package com.harllan.bank;

import com.harllan.bank.interfaces.IAccount;

import lombok.Getter;

@Getter
public class Account implements IAccount {
	
	private static final int DEFAULT_AGENCY = 1;
	private static int SEQUENTIAL = 1;

	protected int agency;
	protected int number;
	protected double balance;
	protected Client client;

	public Account(Client client) {
		this.agency = Account.DEFAULT_AGENCY;
		this.number = SEQUENTIAL++;
		this.client = client;
	}

	public void withdrawMoney(double value) {
		this.balance -= value;
	}

	public void deposit(double value) {
		this.balance += value;
	}

	public void transfer(double value, IAccount destinationAccount) {
		this.withdrawMoney(value);
		destinationAccount.deposit(value);
	}

	public void printExtract() {}
	
	protected void printCommonInfos() {
		System.out.println(String.format("Titular: %s", this.client.getName()));
		System.out.println(String.format("Agência: %d", this.agency));
		System.out.println(String.format("Número: %d", this.number));
		System.out.println(String.format("Saldo: %.2f\n", this.balance));
	}

}
