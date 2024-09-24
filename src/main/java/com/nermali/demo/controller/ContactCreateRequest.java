package com.nermali.demo.controller;

import jakarta.validation.constraints.NotEmpty;

public class ContactCreateRequest {

    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "zipCode is required")
    private String zipCode;

    @NotEmpty(message = "city is required")
    private String city;

    @NotEmpty(message = "number is required")
    private String number;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }
}
