package com.nucleus.bank.model.persistence.account;

import java.math.BigDecimal;
import java.util.List;

import com.nucleus.bank.model.persistence.exceptions.AccountNotFoundException;

public interface AccountDao {
	public void addAccount(Account account);
	public Account updateAccount(String accountNumber,String AccountHolderName,BigDecimal AccountBalance ) throws AccountNotFoundException;
	public Account deleteAccount(String accountNumber)throws AccountNotFoundException;
	public List<Account> getAllAccounts();
	public Account findAccount(String accountNumber)throws AccountNotFoundException;
}
