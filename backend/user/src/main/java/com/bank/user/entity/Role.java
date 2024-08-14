package com.bank.user.entity;

import com.bank.user.dto.RoleDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("role")
@NoArgsConstructor
public class Role {
    @Id
    private Long id;
    private RoleDto.Role role;

    public Role withId(Long id) {
        this.id = id;
        return this;
    }

    public Role withRole(RoleDto.Role role) {
        this.role = role;
        return this;
    }
}
