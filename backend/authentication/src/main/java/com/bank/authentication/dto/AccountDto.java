package com.bank.authentication.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class AccountDto {
    private Long id;
    private String type;
    private String number;
    private Double balance;
    private LocalDate dateOpened;
    private LocalDate dateClosed;
    private String status;
}
