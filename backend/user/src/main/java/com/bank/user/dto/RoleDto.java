
package com.bank.user.dto;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;


/**
 * Role
 * <p>
 * A role is a set of permissions that a user has.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "role"
})
@Generated("jsonschema2pojo")
public class RoleDto {

    /**
     * ID of the role
     */
    @JsonProperty("id")
    @JsonPropertyDescription("ID of the role")
    private Long id;
    /**
     * Name of the role
     * (Required)
     */
    @JsonProperty("role")
    @JsonPropertyDescription("Name of the role")
    private RoleDto.Role role;

    /**
     * ID of the role
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * ID of the role
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public RoleDto withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Name of the role
     * (Required)
     */
    @JsonProperty("role")
    public RoleDto.Role getRole() {
        return role;
    }

    /**
     * Name of the role
     * (Required)
     */
    @JsonProperty("role")
    public void setRole(RoleDto.Role role) {
        this.role = role;
    }

    public RoleDto withRole(RoleDto.Role role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RoleDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("role");
        sb.append('=');
        sb.append(((this.role == null) ? "<null>" : this.role));
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
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.role == null) ? 0 : this.role.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RoleDto) == false) {
            return false;
        }
        RoleDto rhs = ((RoleDto) other);
        return (((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))) && ((this.role == rhs.role) || ((this.role != null) && this.role.equals(rhs.role))));
    }


    /**
     * Name of the role
     */
    @Generated("jsonschema2pojo")
    public enum Role {

        ROLE_ADMIN("ROLE_ADMIN"),
        ROLE_MANAGER("ROLE_MANAGER"),
        ROLE_USER("ROLE_USER");
        private final static Map<String, RoleDto.Role> CONSTANTS = new HashMap<String, RoleDto.Role>();

        static {
            for (RoleDto.Role c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        Role(String value) {
            this.value = value;
        }

        @JsonCreator
        public static RoleDto.Role fromValue(String value) {
            RoleDto.Role constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

    }

}
