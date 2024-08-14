
package com.bank.address.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;


/**
 * AddressDto
 * <p>
 * Address
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "country",
        "state",
        "city",
        "street",
        "house",
        "apartment",
        "zip"
})
@Generated("jsonschema2pojo")
public class AddressDto {

    /**
     * Id
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id")
    private Long id;
    /**
     * (Required)
     */
    @JsonProperty("country")
    private String country;
    /**
     * (Required)
     */
    @JsonProperty("state")
    private String state;
    /**
     * (Required)
     */
    @JsonProperty("city")
    private String city;
    /**
     * (Required)
     */
    @JsonProperty("street")
    private String street;
    /**
     * (Required)
     */
    @JsonProperty("house")
    private Long house;
    @JsonProperty("apartment")
    private Long apartment;
    /**
     * (Required)
     */
    @JsonProperty("zip")
    private Long zip;

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

    public AddressDto withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * (Required)
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * (Required)
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public AddressDto withCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * (Required)
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * (Required)
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    public AddressDto withState(String state) {
        this.state = state;
        return this;
    }

    /**
     * (Required)
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * (Required)
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public AddressDto withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * (Required)
     */
    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    /**
     * (Required)
     */
    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    public AddressDto withStreet(String street) {
        this.street = street;
        return this;
    }

    /**
     * (Required)
     */
    @JsonProperty("house")
    public Long getHouse() {
        return house;
    }

    /**
     * (Required)
     */
    @JsonProperty("house")
    public void setHouse(Long house) {
        this.house = house;
    }

    public AddressDto withHouse(Long house) {
        this.house = house;
        return this;
    }

    @JsonProperty("apartment")
    public Long getApartment() {
        return apartment;
    }

    @JsonProperty("apartment")
    public void setApartment(Long apartment) {
        this.apartment = apartment;
    }

    public AddressDto withApartment(Long apartment) {
        this.apartment = apartment;
        return this;
    }

    /**
     * (Required)
     */
    @JsonProperty("zip")
    public Long getZip() {
        return zip;
    }

    /**
     * (Required)
     */
    @JsonProperty("zip")
    public void setZip(Long zip) {
        this.zip = zip;
    }

    public AddressDto withZip(Long zip) {
        this.zip = zip;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddressDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null) ? "<null>" : this.country));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null) ? "<null>" : this.state));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null) ? "<null>" : this.city));
        sb.append(',');
        sb.append("street");
        sb.append('=');
        sb.append(((this.street == null) ? "<null>" : this.street));
        sb.append(',');
        sb.append("house");
        sb.append('=');
        sb.append(((this.house == null) ? "<null>" : this.house));
        sb.append(',');
        sb.append("apartment");
        sb.append('=');
        sb.append(((this.apartment == null) ? "<null>" : this.apartment));
        sb.append(',');
        sb.append("zip");
        sb.append('=');
        sb.append(((this.zip == null) ? "<null>" : this.zip));
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
        result = ((result * 31) + ((this.zip == null) ? 0 : this.zip.hashCode()));
        result = ((result * 31) + ((this.country == null) ? 0 : this.country.hashCode()));
        result = ((result * 31) + ((this.city == null) ? 0 : this.city.hashCode()));
        result = ((result * 31) + ((this.street == null) ? 0 : this.street.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.state == null) ? 0 : this.state.hashCode()));
        result = ((result * 31) + ((this.house == null) ? 0 : this.house.hashCode()));
        result = ((result * 31) + ((this.apartment == null) ? 0 : this.apartment.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddressDto) == false) {
            return false;
        }
        AddressDto rhs = ((AddressDto) other);
        return (((((((((this.zip == rhs.zip) || ((this.zip != null) && this.zip.equals(rhs.zip))) && ((this.country == rhs.country) || ((this.country != null) && this.country.equals(rhs.country)))) && ((this.city == rhs.city) || ((this.city != null) && this.city.equals(rhs.city)))) && ((this.street == rhs.street) || ((this.street != null) && this.street.equals(rhs.street)))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))) && ((this.state == rhs.state) || ((this.state != null) && this.state.equals(rhs.state)))) && ((this.house == rhs.house) || ((this.house != null) && this.house.equals(rhs.house)))) && ((this.apartment == rhs.apartment) || ((this.apartment != null) && this.apartment.equals(rhs.apartment))));
    }

}
