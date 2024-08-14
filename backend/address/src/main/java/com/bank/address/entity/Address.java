package com.bank.address.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table("address")
public class Address {
    @Id
    private Long id;
    private String country;
    private String state;
    private String city;
    private String street;
    private int house;
    private int apartment;
    private int zip;
}
