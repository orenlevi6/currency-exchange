package com.jb.currencyexchange.advice;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorDetails {
    private String error;
    private String description;
}
