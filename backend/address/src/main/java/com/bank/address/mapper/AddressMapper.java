package com.bank.address.mapper;

import com.bank.address.dto.AddressDto;
import com.bank.address.entity.Address;
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
