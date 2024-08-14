package com.bank.authentication.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table("usr")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ToString.Include(name = "password")
    private String maskPassword() {
        return "********";
    }

    public User withId(Long id) {
        this.id = id;
        return this;
    }

    public User withUsername(String username) {
        this.username = username;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public User withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public User withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public User withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
