package com.bank.authentication.mapper;

import com.bank.authentication.entity.Role;
import com.bank.authentication.generated.RoleDto;
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
