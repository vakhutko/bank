package com.bank.authentication.mapper;

import com.bank.authentication.dto.AccountDto;
import com.bank.authentication.entity.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    Account toAccount(AccountDto accountDto);

    @InheritInverseConfiguration
    AccountDto fromAccount(Account account);
}
