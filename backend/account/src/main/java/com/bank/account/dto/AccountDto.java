
package com.bank.account.dto;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Account
 * <p>
 * Account
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "type",
        "number",
        "balance",
        "dateOpened",
        "dateClosed",
        "status"
})
@Generated("jsonschema2pojo")
public class AccountDto {

    /**
     * Id
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id")
    private Long id;
    /**
     * Type
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type")
    private AccountDto.Type type;
    /**
     * Number
     */
    @JsonProperty("number")
    @JsonPropertyDescription("Number")
    private String number;
    /**
     * Balance
     */
    @JsonProperty("balance")
    @JsonPropertyDescription("Balance")
    private Double balance;
    /**
     * Date Opened
     */
    @JsonProperty("dateOpened")
    @JsonPropertyDescription("Date Opened")
    private LocalDate dateOpened;
    /**
     * Date Closed
     */
    @JsonProperty("dateClosed")
    @JsonPropertyDescription("Date Closed")
    private LocalDate dateClosed;
    /**
     * Status
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Status")
    private AccountDto.Status status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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

    public AccountDto withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Type
     */
    @JsonProperty("type")
    public AccountDto.Type getType() {
        return type;
    }

    /**
     * Type
     */
    @JsonProperty("type")
    public void setType(AccountDto.Type type) {
        this.type = type;
    }

    public AccountDto withType(AccountDto.Type type) {
        this.type = type;
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

    public AccountDto withNumber(String number) {
        this.number = number;
        return this;
    }

    /**
     * Balance
     */
    @JsonProperty("balance")
    public Double getBalance() {
        return balance;
    }

    /**
     * Balance
     */
    @JsonProperty("balance")
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountDto withBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    /**
     * Date Opened
     */
    @JsonProperty("dateOpened")
    public LocalDate getDateOpened() {
        return dateOpened;
    }

    /**
     * Date Opened
     */
    @JsonProperty("dateOpened")
    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public AccountDto withDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
        return this;
    }

    /**
     * Date Closed
     */
    @JsonProperty("dateClosed")
    public LocalDate getDateClosed() {
        return dateClosed;
    }

    /**
     * Date Closed
     */
    @JsonProperty("dateClosed")
    public void setDateClosed(LocalDate dateClosed) {
        this.dateClosed = dateClosed;
    }

    public AccountDto withDateClosed(LocalDate dateClosed) {
        this.dateClosed = dateClosed;
        return this;
    }

    /**
     * Status
     */
    @JsonProperty("status")
    public AccountDto.Status getStatus() {
        return status;
    }

    /**
     * Status
     */
    @JsonProperty("status")
    public void setStatus(AccountDto.Status status) {
        this.status = status;
    }

    public AccountDto withStatus(AccountDto.Status status) {
        this.status = status;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public AccountDto withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AccountDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("number");
        sb.append('=');
        sb.append(((this.number == null) ? "<null>" : this.number));
        sb.append(',');
        sb.append("balance");
        sb.append('=');
        sb.append(((this.balance == null) ? "<null>" : this.balance));
        sb.append(',');
        sb.append("dateOpened");
        sb.append('=');
        sb.append(((this.dateOpened == null) ? "<null>" : this.dateOpened));
        sb.append(',');
        sb.append("dateClosed");
        sb.append('=');
        sb.append(((this.dateClosed == null) ? "<null>" : this.dateClosed));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null) ? "<null>" : this.status));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
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
        result = ((result * 31) + ((this.dateOpened == null) ? 0 : this.dateOpened.hashCode()));
        result = ((result * 31) + ((this.balance == null) ? 0 : this.balance.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.dateClosed == null) ? 0 : this.dateClosed.hashCode()));
        result = ((result * 31) + ((this.status == null) ? 0 : this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccountDto) == false) {
            return false;
        }
        AccountDto rhs = ((AccountDto) other);
        return (((((((((this.number == rhs.number) || ((this.number != null) && this.number.equals(rhs.number))) && ((this.dateOpened == rhs.dateOpened) || ((this.dateOpened != null) && this.dateOpened.equals(rhs.dateOpened)))) && ((this.balance == rhs.balance) || ((this.balance != null) && this.balance.equals(rhs.balance)))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type)))) && ((this.dateClosed == rhs.dateClosed) || ((this.dateClosed != null) && this.dateClosed.equals(rhs.dateClosed)))) && ((this.status == rhs.status) || ((this.status != null) && this.status.equals(rhs.status))));
    }


    /**
     * Status
     */
    @Generated("jsonschema2pojo")
    public enum Status {

        START("start"),
        ADVANCE("advance"),
        PREMIUM("premium");
        private final static Map<String, AccountDto.Status> CONSTANTS = new HashMap<String, AccountDto.Status>();

        static {
            for (AccountDto.Status c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        Status(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AccountDto.Status fromValue(String value) {
            AccountDto.Status constant = CONSTANTS.get(value);
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

        DEBIT("debit"),
        CREDIT("credit");
        private final static Map<String, AccountDto.Type> CONSTANTS = new HashMap<String, AccountDto.Type>();

        static {
            for (AccountDto.Type c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        Type(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AccountDto.Type fromValue(String value) {
            AccountDto.Type constant = CONSTANTS.get(value);
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
