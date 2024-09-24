package com.nermali.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nermali.demo.model.ProductionInstallation;

public interface ProductionInstallationRepositoryCustom {

    Page<ProductionInstallation> findByCriteria(final ProductionInstallationSearchCriteria searchCriteria, final Pageable pageable);

}
