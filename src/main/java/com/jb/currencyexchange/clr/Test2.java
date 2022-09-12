package com.jb.currencyexchange.clr;

import com.jb.currencyexchange.services.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
@Order(2)
public class Test2 implements CommandLineRunner {
    private final ExchangeService exchangeService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(exchangeService.convert("ILS", "ILS", 100));
        System.out.println(exchangeService.convert("ILS", "USD", 100));
        System.out.println(exchangeService.convert("USD", "ILS", 100));
        System.out.println(exchangeService.convert("GBP", "USD", 100));
    }

}
