package com.bank.authentication.mapper;

import com.bank.authentication.dto.AddressDto;
import com.bank.authentication.entity.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    Address toAddress(AddressDto addressDto);

    @InheritInverseConfiguration
    AddressDto fromAddress(Address address);
}
