package com.jb.currencyexchange.clr;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

//@Component
@RequiredArgsConstructor
@Order(1)
public class Test1 implements CommandLineRunner {
    private final String URL = "https://api.exchangerate-api.com/v4/latest/USD";
    private final RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        String result = restTemplate.getForObject(URL, String.class);
        System.out.println(result);

        Map<String, Object> resultAsMap = restTemplate.getForObject(URL, Map.class);
        Map<String, Double> currencies = (Map<String, Double>) resultAsMap.get("rates");
        System.out.println(currencies);
    }

}
