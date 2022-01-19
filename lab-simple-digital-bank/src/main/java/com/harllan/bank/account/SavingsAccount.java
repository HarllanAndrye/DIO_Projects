package com.harllan.bank.account;

import com.harllan.bank.Account;
import com.harllan.bank.Client;

public class SavingsAccount extends Account {

	public SavingsAccount(Client client) {
		super(client);
	}

	@Override
	public void printExtract() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.printCommonInfos();
	}

}
