package com.nermali.demo.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String number;

    @OneToMany(mappedBy = "contact",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<ProductionInstallation> productionInstallations = new ArrayList<>();

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

    public List<ProductionInstallation> getProductionInstallations() {
        return productionInstallations;
    }

    public void setProductionInstallations(final List<ProductionInstallation> productionInstallations) {
        this.productionInstallations = productionInstallations;
    }

    public void addProductionInstallation(final ProductionInstallation productionInstallation) {
        productionInstallations.add(productionInstallation);
        productionInstallation.setContact(this);
    }

    public void removeProductionInstallation(final ProductionInstallation productionInstallation) {
        productionInstallations.remove(productionInstallation);
        productionInstallation.setContact(null);
    }

}
