package com.bank.transaction.mapper;

import com.bank.transaction.dto.TransactionDto;
import com.bank.transaction.entity.Transaction;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {
    Transaction toTransaction(TransactionDto transactionDto);

    @InheritInverseConfiguration
    TransactionDto fromTransaction(Transaction transaction);
}
