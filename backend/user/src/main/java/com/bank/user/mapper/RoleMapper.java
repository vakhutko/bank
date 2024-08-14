package com.bank.user.mapper;

import com.bank.user.dto.RoleDto;
import com.bank.user.entity.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    Role toRole(RoleDto roleDto);

    @InheritInverseConfiguration
    RoleDto fromRole(Role role);
}
