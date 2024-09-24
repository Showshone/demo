package com.nermali.demo.controller;

import com.nermali.demo.repository.ProductionInstallationSearchCriteria;
import org.springframework.data.domain.PageRequest;

public class ProductionInstallationSearchRequest {

    private String name;
    private Integer minOutput;
    private Integer maxOutput;
    private Integer page;
    private Integer size;


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

    public Integer getPage() {
        return page;
    }

    public void setPage(final Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(final Integer size) {
        this.size = size;
    }

    public ProductionInstallationSearchCriteria toSearchCriteria() {
        return new ProductionInstallationSearchCriteria(name, minOutput, maxOutput);
    }
    public PageRequest getPageRequest() {
        return PageRequest.of(page, size);
    }
}
