package com.jb.currencyexchange.services;

import com.jb.currencyexchange.beans.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExchangeService {
    private final String URL = "https://api.exchangerate-api.com/v4/latest/USD";
    private final RestTemplate restTemplate;
    private Map<String, Double> currencies = new HashMap<>();

    public Currency convert(String from, String to, double amount) {
        double sum;

        if (currencies.isEmpty()) {
            getCurrencies();
        }
        
        if (from.equalsIgnoreCase(to)) {
            sum = amount;
        } else if (from.equalsIgnoreCase("USD")) {
            sum = amount * currencies.get(to.toUpperCase());
        } else if (to.equalsIgnoreCase("USD")) {
            sum = amount / currencies.get(from.toUpperCase());
        } else {
            sum = amount * (currencies.get(to.toUpperCase()) / currencies.get(from.toUpperCase()));
        }
        return new Currency(
                from,
                to,
                amount,
                sum
        );
    }

    @Scheduled(cron = "0 0 0 * * ?", zone = "Asia/Jerusalem")
    private void getCurrencies() {
        currencies.clear();
        Map<String, Object> result = restTemplate.getForObject(URL, Map.class);
        currencies = (Map<String, Double>) result.get("rates");
    }

}
