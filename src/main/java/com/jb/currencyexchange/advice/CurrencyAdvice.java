package com.jb.currencyexchange.advice;

import com.jb.currencyexchange.exceptions.CurrencyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CurrencyAdvice {
    @ExceptionHandler({CurrencyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleCurrencyException(Exception err) {
        return new ErrorDetails("Currency Error", err.getMessage());
    }

}
