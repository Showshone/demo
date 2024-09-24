package com.nermali.demo.repository;

public class ProductionInstallationSearchCriteria {

    private String name;
    private Integer minOutput;
    private Integer maxOutput;

    public ProductionInstallationSearchCriteria(final String name, final Integer minOutput, final Integer maxOutput) {
        this.name = name;
        this.minOutput = minOutput;
        this.maxOutput = maxOutput;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getMinOutput() {
        return minOutput;
    }

    public void setMinOutput(final Integer minOutput) {
        this.minOutput = minOutput;
    }

    public Integer getMaxOutput() {
        return maxOutput;
    }

    public void setMaxOutput(final Integer maxOutput) {
        this.maxOutput = maxOutput;
    }
}
