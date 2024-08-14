package com.bank.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "usr_role")
@NoArgsConstructor
public class UserRole {
    @Id
    private Long id;
    private Long usrId;
    private Long roleId;

    public UserRole(Long usrId, Long roleId) {
        this.usrId = usrId;
        this.roleId = roleId;
    }
}
