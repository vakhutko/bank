
package com.bank.transaction.dto;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Transaction
 * <p>
 * Transaction
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "payerAccount",
        "payeeAccount",
        "amount",
        "currency",
        "createdAt"
})
@Generated("jsonschema2pojo")
public class TransactionDto {

    /**
     * ID of the transaction
     */
    @JsonProperty("id")
    @JsonPropertyDescription("ID of the transaction")
    private UUID id;
    /**
     * Account ID of the payer
     * (Required)
     */
    @JsonProperty("payerAccount")
    @JsonPropertyDescription("Account ID of the payer")
    private String payerAccount;
    /**
     * Account ID of the payee
     * (Required)
     */
    @JsonProperty("payeeAccount")
    @JsonPropertyDescription("Account ID of the payee")
    private String payeeAccount;
    /**
     * Amount of the transaction
     * (Required)
     */
    @JsonProperty("amount")
    @JsonPropertyDescription("Amount of the transaction")
    private Double amount;
    /**
     * Currency of the transaction
     * (Required)
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("Currency of the transaction")
    private TransactionDto.Currency currency;
    /**
     * Timestamp of the transaction
     */
    @JsonProperty("createdAt")
    @JsonPropertyDescription("Timestamp of the transaction")
    private LocalDateTime createdAt;

    /**
     * ID of the transaction
     */
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    /**
     * ID of the transaction
     */
    @JsonProperty("id")
    public void setId(UUID id) {
        this.id = id;
    }

    public TransactionDto withId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Account ID of the payer
     * (Required)
     */
    @JsonProperty("payerAccount")
    public String getPayerAccount() {
        return payerAccount;
    }

    /**
     * Account ID of the payer
     * (Required)
     */
    @JsonProperty("payerAccount")
    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
    }

    public TransactionDto withPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
        return this;
    }

    /**
     * Account ID of the payee
     * (Required)
     */
    @JsonProperty("payeeAccount")
    public String getPayeeAccount() {
        return payeeAccount;
    }

    /**
     * Account ID of the payee
     * (Required)
     */
    @JsonProperty("payeeAccount")
    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

    public TransactionDto withPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
        return this;
    }

    /**
     * Amount of the transaction
     * (Required)
     */
    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    /**
     * Amount of the transaction
     * (Required)
     */
    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionDto withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Currency of the transaction
     * (Required)
     */
    @JsonProperty("currency")
    public TransactionDto.Currency getCurrency() {
        return currency;
    }

    /**
     * Currency of the transaction
     * (Required)
     */
    @JsonProperty("currency")
    public void setCurrency(TransactionDto.Currency currency) {
        this.currency = currency;
    }

    public TransactionDto withCurrency(TransactionDto.Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Timestamp of the transaction
     */
    @JsonProperty("createdAt")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Timestamp of the transaction
     */
    @JsonProperty("createdAt")
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public TransactionDto withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TransactionDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("payerAccount");
        sb.append('=');
        sb.append(((this.payerAccount == null) ? "<null>" : this.payerAccount));
        sb.append(',');
        sb.append("payeeAccount");
        sb.append('=');
        sb.append(((this.payeeAccount == null) ? "<null>" : this.payeeAccount));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null) ? "<null>" : this.amount));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null) ? "<null>" : this.currency));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null) ? "<null>" : this.createdAt));
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
        result = ((result * 31) + ((this.payerAccount == null) ? 0 : this.payerAccount.hashCode()));
        result = ((result * 31) + ((this.createdAt == null) ? 0 : this.createdAt.hashCode()));
        result = ((result * 31) + ((this.amount == null) ? 0 : this.amount.hashCode()));
        result = ((result * 31) + ((this.currency == null) ? 0 : this.currency.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.payeeAccount == null) ? 0 : this.payeeAccount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionDto) == false) {
            return false;
        }
        TransactionDto rhs = ((TransactionDto) other);
        return (((((((this.payerAccount == rhs.payerAccount) || ((this.payerAccount != null) && this.payerAccount.equals(rhs.payerAccount))) && ((this.createdAt == rhs.createdAt) || ((this.createdAt != null) && this.createdAt.equals(rhs.createdAt)))) && ((this.amount == rhs.amount) || ((this.amount != null) && this.amount.equals(rhs.amount)))) && ((this.currency == rhs.currency) || ((this.currency != null) && this.currency.equals(rhs.currency)))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))) && ((this.payeeAccount == rhs.payeeAccount) || ((this.payeeAccount != null) && this.payeeAccount.equals(rhs.payeeAccount))));
    }


    /**
     * Currency of the transaction
     */
    @Generated("jsonschema2pojo")
    public enum Currency {

        USD("USD"),
        EUR("EUR"),
        GBP("GBP"),
        JPY("JPY"),
        CNY("CNY"),
        RUB("RUB");
        private final static Map<String, TransactionDto.Currency> CONSTANTS = new HashMap<String, TransactionDto.Currency>();

        static {
            for (TransactionDto.Currency c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        Currency(String value) {
            this.value = value;
        }

        @JsonCreator
        public static TransactionDto.Currency fromValue(String value) {
            TransactionDto.Currency constant = CONSTANTS.get(value);
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
