package com.bank.user.mapper;

import com.bank.user.dto.UserDto;
import com.bank.user.entity.User;
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
