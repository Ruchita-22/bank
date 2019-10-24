package com.nucleus.bank.model.persistence.exceptions;

public class AccountNotFoundException extends Exception {

	private static final long serialVersionUID = -8344258775606086367L;

	public AccountNotFoundException() {
		super();

	}

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

}
