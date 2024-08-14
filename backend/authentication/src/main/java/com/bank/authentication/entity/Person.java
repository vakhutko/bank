package com.bank.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {
    @Id
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
    private Long userId;
    private Long addressId;
    private Long accountId;
}
