package com.nucleus.bank.model.service.account;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nucleus.bank.model.persistence.account.Account;
import com.nucleus.bank.model.persistence.account.AccountDao;
import com.nucleus.bank.model.persistence.exceptions.AccountNotFoundException;

@Service(value="service")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AccountServiceImp implements AccountService {
	@Autowired
	private AccountDao accountDao;
	
	

	public AccountServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AccountServiceImp(AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}


	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void addAccount(Account account) {
		accountDao.addAccount(account);

	}

	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Account updateAccount(String accountNumber,String AccountHolderName,BigDecimal AccountBalance ) throws AccountNotFoundException {
		Account account = accountDao.updateAccount(accountNumber,AccountHolderName, AccountBalance);
		return account;
	}

	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Account deleteAccount(String accountNumber) throws AccountNotFoundException {
		Account account = accountDao.deleteAccount(accountNumber);
		return account;
	}

	@Transactional(readOnly=true, propagation = Propagation.REQUIRED)
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountDao.getAllAccounts();
		return accounts;
	}

	@Transactional(readOnly=true, propagation = Propagation.REQUIRED)
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		Account account = accountDao.findAccount(accountNumber);
		return account;
	}


	

}
