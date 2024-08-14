package com.bank.account.mapper;

import com.bank.account.dto.AccountDto;
import com.bank.account.entity.Account;
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
