package com.harllan.bank;

import java.util.List;

import lombok.Data;

@Data
public class Bank {

	private String name;
	private List<Account> accounts;

}
