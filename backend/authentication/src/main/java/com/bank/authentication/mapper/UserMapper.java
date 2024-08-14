package com.bank.authentication.mapper;

import com.bank.authentication.entity.User;
import com.bank.authentication.generated.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User toUser(UserDto dto);

    @InheritInverseConfiguration
    UserDto fromUser(User user);
}
