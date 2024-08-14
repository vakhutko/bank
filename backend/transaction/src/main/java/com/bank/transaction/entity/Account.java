package com.bank.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table("account")
public class Account {
    @Id
    private Long id;
    private String type;
    private String number;
    private Double balance;
    private LocalDate dateOpened;
    private LocalDate dateClosed;
    private String status;
}
