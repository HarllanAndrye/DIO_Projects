package com.harllan;

import com.harllan.bank.Account;
import com.harllan.bank.Client;
import com.harllan.bank.account.CheckingAccount;
import com.harllan.bank.account.SavingsAccount;

public class Init {

	public static void main(String[] args) {
		Client client = new Client();
		client.setName("Harllan");
		
		Account cc = new CheckingAccount(client);
		Account poupanca = new SavingsAccount(client);

		cc.deposit(1000);
		cc.transfer(255, poupanca);
		
		cc.printExtract();
		poupanca.printExtract();
	}

}
