package com.harllan.bank.interfaces;

public interface IAccount {

	void withdrawMoney(double value);

	void deposit(double value);

	void transfer(double value, IAccount destinationAccount);

	void printExtract();

}
