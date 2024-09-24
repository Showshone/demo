package com.nermali.demo.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "production_installation", indexes = {
        @Index(columnList = "output_power", name = "output_power_index")
})
public class ProductionInstallation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Contact contact;

    @Column(name = "output_power", nullable = false)
    private BigDecimal outputPower;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(final Contact contact) {
        this.contact = contact;
    }

    public BigDecimal getOutputPower() {
        return outputPower;
    }

    public void setOutputPower(final BigDecimal outputPower) {
        this.outputPower = outputPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductionInstallation )) return false;
        return id != null && id.equals(((ProductionInstallation) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
