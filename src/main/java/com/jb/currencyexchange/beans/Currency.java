package com.jb.currencyexchange.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Currency {
    private String from;
    private String to;
    private double amount;
    private double sum;
}
