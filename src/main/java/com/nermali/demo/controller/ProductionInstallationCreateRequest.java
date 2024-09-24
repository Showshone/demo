package com.nermali.demo.controller;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductionInstallationCreateRequest {

    @NotEmpty(message = "name is required")
    private String name;

    @NotNull(message = "contactId is required")
    private Long contactId;

    @DecimalMin(value = "0.0001", message = "percentage must be larger than 0.0001")
    @DecimalMax(value = "999999", message = "percentage must be lower than 999999")
    @Digits(integer = 10, fraction = 4)
    @NotNull(message = "outputPower is required")
    private BigDecimal outputPower;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(final Long contactId) {
        this.contactId = contactId;
    }

    public BigDecimal getOutputPower() {
        return outputPower;
    }

    public void setOutputPower(final BigDecimal outputPower) {
        this.outputPower = outputPower;
    }
}
