package com.harllan.bank.account;

import com.harllan.bank.Account;
import com.harllan.bank.Client;

public class CheckingAccount extends Account {

	public CheckingAccount(Client client) {
		super(client);
	}

	@Override
	public void printExtract() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.printCommonInfos();
	}

}
