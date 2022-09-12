package com.jb.currencyexchange.controllers;

import com.jb.currencyexchange.exceptions.CurrencyException;
import com.jb.currencyexchange.services.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExchangeController {
    private final ExchangeService exchangeService;

    @GetMapping("/{from}/{to}/{amount}")
    public ResponseEntity<?> convert(@PathVariable String from, @PathVariable String to, @PathVariable double amount) throws CurrencyException {
        try {
            return new ResponseEntity<>(exchangeService.convert(from, to, amount), HttpStatus.OK);
        } catch (NullPointerException err) {
            throw new CurrencyException("Invalid currency");
        }
    }

}
