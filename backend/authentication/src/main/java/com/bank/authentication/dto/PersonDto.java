package com.bank.authentication.dto;

import com.bank.authentication.generated.UserDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Data
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class PersonDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserDto user;
    private AddressDto address;
    private AccountDto account;
}
