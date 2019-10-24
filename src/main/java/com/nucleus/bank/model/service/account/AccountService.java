package com.nucleus.bank.model.service.account;

import java.math.BigDecimal;
import java.util.List;

import com.nucleus.bank.model.persistence.account.Account;
import com.nucleus.bank.model.persistence.exceptions.AccountNotFoundException;

public interface AccountService {
	public void addAccount(Account account);
	public Account updateAccount(String accountNumber,String AccountHolderName,BigDecimal AccountBalance ) throws AccountNotFoundException;
	public Account deleteAccount(String accountNumber)throws AccountNotFoundException;
	public List<Account> getAllAccounts();
	public Account findAccount(String accountNumber)throws AccountNotFoundException;

}
