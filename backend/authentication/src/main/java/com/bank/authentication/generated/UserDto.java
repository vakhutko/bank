
package com.bank.authentication.generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * User
 * <p>
 * A user schema
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "username",
        "password",
        "enabled",
        "createdAt",
        "updatedAt",
        "roles"
})
@Generated("jsonschema2pojo")
public class UserDto {

    /**
     * ID of the user
     */
    @JsonProperty("id")
    @JsonPropertyDescription("ID of the user")
    private Long id;
    /**
     * Username of the user
     * (Required)
     */
    @JsonProperty("username")
    @JsonPropertyDescription("Username of the user")
    private String username;
    /**
     * Password of the user
     * (Required)
     */
    @JsonProperty("password")
    @JsonPropertyDescription("Password of the user")
    private String password;
    /**
     * Whether the user is enabled
     */
    @JsonProperty("enabled")
    @JsonPropertyDescription("Whether the user is enabled")
    private Boolean enabled;
    /**
     * Timestamp of when the user was created
     */
    @JsonProperty("createdAt")
    @JsonPropertyDescription("Timestamp of when the user was created")
    private LocalDateTime createdAt;
    /**
     * Timestamp of when the user was last updated
     */
    @JsonProperty("updatedAt")
    @JsonPropertyDescription("Timestamp of when the user was last updated")
    private LocalDateTime updatedAt;
    /**
     * Roles of the user
     */
    @JsonProperty("roles")
    @JsonPropertyDescription("Roles of the user")
    private List<RoleDto> roles = new ArrayList<RoleDto>();

    /**
     * ID of the user
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * ID of the user
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public UserDto withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Username of the user
     * (Required)
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * Username of the user
     * (Required)
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public UserDto withUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * Password of the user
     * (Required)
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * Password of the user
     * (Required)
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    public UserDto withPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Whether the user is enabled
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Whether the user is enabled
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public UserDto withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Timestamp of when the user was created
     */
    @JsonProperty("createdAt")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Timestamp of when the user was created
     */
    @JsonProperty("createdAt")
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserDto withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Timestamp of when the user was last updated
     */
    @JsonProperty("updatedAt")
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Timestamp of when the user was last updated
     */
    @JsonProperty("updatedAt")
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserDto withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Roles of the user
     */
    @JsonProperty("roles")
    public List<RoleDto> getRoles() {
        return roles;
    }

    /**
     * Roles of the user
     */
    @JsonProperty("roles")
    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public UserDto withRoles(List<RoleDto> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UserDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("username");
        sb.append('=');
        sb.append(((this.username == null) ? "<null>" : this.username));
        sb.append(',');
        sb.append("password");
        sb.append('=');
        sb.append(((this.password == null) ? "<null>" : this.password));
        sb.append(',');
        sb.append("enabled");
        sb.append('=');
        sb.append(((this.enabled == null) ? "<null>" : this.enabled));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null) ? "<null>" : this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null) ? "<null>" : this.updatedAt));
        sb.append(',');
        sb.append("roles");
        sb.append('=');
        sb.append(((this.roles == null) ? "<null>" : this.roles));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.createdAt == null) ? 0 : this.createdAt.hashCode()));
        result = ((result * 31) + ((this.password == null) ? 0 : this.password.hashCode()));
        result = ((result * 31) + ((this.roles == null) ? 0 : this.roles.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.enabled == null) ? 0 : this.enabled.hashCode()));
        result = ((result * 31) + ((this.username == null) ? 0 : this.username.hashCode()));
        result = ((result * 31) + ((this.updatedAt == null) ? 0 : this.updatedAt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserDto) == false) {
            return false;
        }
        UserDto rhs = ((UserDto) other);
        return ((((((((this.createdAt == rhs.createdAt) || ((this.createdAt != null) && this.createdAt.equals(rhs.createdAt))) && ((this.password == rhs.password) || ((this.password != null) && this.password.equals(rhs.password)))) && ((this.roles == rhs.roles) || ((this.roles != null) && this.roles.equals(rhs.roles)))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))) && ((this.enabled == rhs.enabled) || ((this.enabled != null) && this.enabled.equals(rhs.enabled)))) && ((this.username == rhs.username) || ((this.username != null) && this.username.equals(rhs.username)))) && ((this.updatedAt == rhs.updatedAt) || ((this.updatedAt != null) && this.updatedAt.equals(rhs.updatedAt))));
    }

}
