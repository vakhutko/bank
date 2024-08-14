
package com.bank.card.dto;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


/**
 * Card
 * <p>
 * Card
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "number",
        "expirationDate",
        "securityCode",
        "pin",
        "type",
        "status",
        "createdAt",
        "updatedAt",
        "deletedAt"
})
@Generated("jsonschema2pojo")
public class CardDto {

    /**
     * Id
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id")
    private Long id;
    /**
     * Number
     */
    @JsonProperty("number")
    @JsonPropertyDescription("Number")
    private String number;
    /**
     * Expiration Date
     */
    @JsonProperty("expirationDate")
    @JsonPropertyDescription("Expiration Date")
    private String expirationDate;
    /**
     * Security Code
     */
    @JsonProperty("securityCode")
    @JsonPropertyDescription("Security Code")
    private String securityCode;
    /**
     * Pin
     */
    @JsonProperty("pin")
    @JsonPropertyDescription("Pin")
    private String pin;
    /**
     * Type
     * (Required)
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type")
    private CardDto.Type type;
    /**
     * Status
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Status")
    private CardDto.Status status;
    /**
     * Created At
     */
    @JsonProperty("createdAt")
    @JsonPropertyDescription("Created At")
    private LocalDateTime createdAt;
    /**
     * Updated At
     */
    @JsonProperty("updatedAt")
    @JsonPropertyDescription("Updated At")
    private LocalDateTime updatedAt;
    /**
     * Deleted At
     */
    @JsonProperty("deletedAt")
    @JsonPropertyDescription("Deleted At")
    private LocalDateTime deletedAt;

    /**
     * Id
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * Id
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public CardDto withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Number
     */
    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    /**
     * Number
     */
    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    public CardDto withNumber(String number) {
        this.number = number;
        return this;
    }

    /**
     * Expiration Date
     */
    @JsonProperty("expirationDate")
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Expiration Date
     */
    @JsonProperty("expirationDate")
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CardDto withExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    /**
     * Security Code
     */
    @JsonProperty("securityCode")
    public String getSecurityCode() {
        return securityCode;
    }

    /**
     * Security Code
     */
    @JsonProperty("securityCode")
    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public CardDto withSecurityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }

    /**
     * Pin
     */
    @JsonProperty("pin")
    public String getPin() {
        return pin;
    }

    /**
     * Pin
     */
    @JsonProperty("pin")
    public void setPin(String pin) {
        this.pin = pin;
    }

    public CardDto withPin(String pin) {
        this.pin = pin;
        return this;
    }

    /**
     * Type
     * (Required)
     */
    @JsonProperty("type")
    public CardDto.Type getType() {
        return type;
    }

    /**
     * Type
     * (Required)
     */
    @JsonProperty("type")
    public void setType(CardDto.Type type) {
        this.type = type;
    }

    public CardDto withType(CardDto.Type type) {
        this.type = type;
        return this;
    }

    /**
     * Status
     */
    @JsonProperty("status")
    public CardDto.Status getStatus() {
        return status;
    }

    /**
     * Status
     */
    @JsonProperty("status")
    public void setStatus(CardDto.Status status) {
        this.status = status;
    }

    public CardDto withStatus(CardDto.Status status) {
        this.status = status;
        return this;
    }

    /**
     * Created At
     */
    @JsonProperty("createdAt")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Created At
     */
    @JsonProperty("createdAt")
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public CardDto withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Updated At
     */
    @JsonProperty("updatedAt")
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Updated At
     */
    @JsonProperty("updatedAt")
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CardDto withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Deleted At
     */
    @JsonProperty("deletedAt")
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    /**
     * Deleted At
     */
    @JsonProperty("deletedAt")
    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public CardDto withDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CardDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("number");
        sb.append('=');
        sb.append(((this.number == null) ? "<null>" : this.number));
        sb.append(',');
        sb.append("expirationDate");
        sb.append('=');
        sb.append(((this.expirationDate == null) ? "<null>" : this.expirationDate));
        sb.append(',');
        sb.append("securityCode");
        sb.append('=');
        sb.append(((this.securityCode == null) ? "<null>" : this.securityCode));
        sb.append(',');
        sb.append("pin");
        sb.append('=');
        sb.append(((this.pin == null) ? "<null>" : this.pin));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null) ? "<null>" : this.status));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null) ? "<null>" : this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null) ? "<null>" : this.updatedAt));
        sb.append(',');
        sb.append("deletedAt");
        sb.append('=');
        sb.append(((this.deletedAt == null) ? "<null>" : this.deletedAt));
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
        result = ((result * 31) + ((this.number == null) ? 0 : this.number.hashCode()));
        result = ((result * 31) + ((this.createdAt == null) ? 0 : this.createdAt.hashCode()));
        result = ((result * 31) + ((this.deletedAt == null) ? 0 : this.deletedAt.hashCode()));
        result = ((result * 31) + ((this.pin == null) ? 0 : this.pin.hashCode()));
        result = ((result * 31) + ((this.securityCode == null) ? 0 : this.securityCode.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.expirationDate == null) ? 0 : this.expirationDate.hashCode()));
        result = ((result * 31) + ((this.status == null) ? 0 : this.status.hashCode()));
        result = ((result * 31) + ((this.updatedAt == null) ? 0 : this.updatedAt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardDto) == false) {
            return false;
        }
        CardDto rhs = ((CardDto) other);
        return (((((((((((this.number == rhs.number) || ((this.number != null) && this.number.equals(rhs.number))) && ((this.createdAt == rhs.createdAt) || ((this.createdAt != null) && this.createdAt.equals(rhs.createdAt)))) && ((this.deletedAt == rhs.deletedAt) || ((this.deletedAt != null) && this.deletedAt.equals(rhs.deletedAt)))) && ((this.pin == rhs.pin) || ((this.pin != null) && this.pin.equals(rhs.pin)))) && ((this.securityCode == rhs.securityCode) || ((this.securityCode != null) && this.securityCode.equals(rhs.securityCode)))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))) && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type)))) && ((this.expirationDate == rhs.expirationDate) || ((this.expirationDate != null) && this.expirationDate.equals(rhs.expirationDate)))) && ((this.status == rhs.status) || ((this.status != null) && this.status.equals(rhs.status)))) && ((this.updatedAt == rhs.updatedAt) || ((this.updatedAt != null) && this.updatedAt.equals(rhs.updatedAt))));
    }


    /**
     * Status
     */
    @Generated("jsonschema2pojo")
    public enum Status {

        ACTIVE("active"),
        INACTIVE("inactive"),
        BLOCKED("blocked"),
        EXPIRED("expired");
        private final static Map<String, CardDto.Status> CONSTANTS = new HashMap<String, CardDto.Status>();

        static {
            for (CardDto.Status c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        Status(String value) {
            this.value = value;
        }

        @JsonCreator
        public static CardDto.Status fromValue(String value) {
            CardDto.Status constant = CONSTANTS.get(value);
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


    /**
     * Type
     */
    @Generated("jsonschema2pojo")
    public enum Type {

        VISA("VISA"),
        MASTERCARD("MASTERCARD"),
        AMEX("AMEX"),
        DISCOVER("DISCOVER"),
        JCB("JCB"),
        MAESTRO("MAESTRO"),
        MIR("MIR");
        private final static Map<String, CardDto.Type> CONSTANTS = new HashMap<String, CardDto.Type>();

        static {
            for (CardDto.Type c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        Type(String value) {
            this.value = value;
        }

        @JsonCreator
        public static CardDto.Type fromValue(String value) {
            CardDto.Type constant = CONSTANTS.get(value);
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
