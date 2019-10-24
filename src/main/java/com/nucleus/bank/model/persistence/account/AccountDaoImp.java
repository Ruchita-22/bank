package com.nucleus.bank.model.persistence.account;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nucleus.bank.model.persistence.exceptions.AccountNotFoundException;

@Repository(value = "dao")
public class AccountDaoImp implements AccountDao {
	@Autowired
	private SessionFactory sessionFactory;

	public AccountDaoImp() {

	}

	public AccountDaoImp(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	
	
	public void addAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.save(account);
	}


	
	public Account updateAccount(String accountNumber,String AccountHolderName,BigDecimal AccountBalance ) throws AccountNotFoundException {
		Session session = sessionFactory.getCurrentSession();
		Account account = (Account) session.get(Account.class, accountNumber);
		if (account == null) {
				throw new AccountNotFoundException();
		} else {
			account.setAccountHolderName(AccountHolderName);
			account.setAccountBalance(AccountBalance);
			session.update(account);
			return account;
		}
	}

	
	
	public Account deleteAccount(String accountNumber) throws AccountNotFoundException {
		Session session = sessionFactory.getCurrentSession();
		Account account = (Account) session.get(Account.class, accountNumber);
		if (account == null) {
			throw new AccountNotFoundException();
		} else {
			account.setStatusFlag("Inactive");
			session.update(account);
		}
		return account;
	}

	@SuppressWarnings("unchecked")
		public List<Account> getAllAccounts() {
		Session session = sessionFactory.getCurrentSession();
		List<Account> accounts = session.createQuery("from Account").list();
		return accounts;
	}

	
	public Account findAccount(String accountNumber) throws AccountNotFoundException{
		Session session = sessionFactory.getCurrentSession();
		Account account = (Account) session.get(Account.class, accountNumber);
		if(account==null){
			throw new AccountNotFoundException();
		}
		else
			return account;
	}

	
	
}
