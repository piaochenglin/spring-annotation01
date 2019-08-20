package com.piao.hibernate;

public class AccountException extends RuntimeException {

    public AccountException() {
        super();
    }

    public AccountException(String message) {
        super(message);
    }
}
