package com.bank.authentication.mapper;

import com.bank.authentication.dto.PersonDto;
import com.bank.authentication.entity.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {
    Person toPerson(PersonDto personDto);

    @InheritInverseConfiguration
    PersonDto fromPerson(Person person);
}
