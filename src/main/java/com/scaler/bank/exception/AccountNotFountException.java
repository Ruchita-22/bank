package com.scaler.bank.exception;

public class AccountNotFountException extends Exception{
    public AccountNotFountException() {
    }

    public AccountNotFountException(String message) {
        super(message);
    }

    public AccountNotFountException(String message, Throwable cause) {
        super(message, cause);
    }
}
