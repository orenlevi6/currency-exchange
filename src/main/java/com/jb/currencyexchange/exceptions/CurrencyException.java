package com.jb.currencyexchange.exceptions;

public class CurrencyException extends Exception {
    public CurrencyException() {
        super("Currency Exception");
    }

    public CurrencyException(String message) {
        super(message);
    }

}
