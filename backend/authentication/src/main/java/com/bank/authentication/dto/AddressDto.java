package com.bank.authentication.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class AddressDto {
    private Long id;
    private String country;
    private String state;
    private String city;
    private String street;
    private int house;
    private int apartment;
}
