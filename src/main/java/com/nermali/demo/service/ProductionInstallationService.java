package com.nermali.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nermali.demo.controller.ProductionInstallationCreateRequest;
import com.nermali.demo.controller.ProductionInstallationSearchRequest;
import com.nermali.demo.model.Contact;
import com.nermali.demo.model.ProductionInstallation;
import com.nermali.demo.repository.ProductionInstallationRepositoryImpl;

@Service
public class ProductionInstallationService {

    private final ProductionInstallationRepositoryImpl productionInstallationRepository;

    public ProductionInstallationService(final ProductionInstallationRepositoryImpl productionInstallationRepository) {
        this.productionInstallationRepository = productionInstallationRepository;
    }

    public Page<ProductionInstallation> findAll(final PageRequest pageRequest) {
        return productionInstallationRepository.findAll(pageRequest);
    }

    public Optional<ProductionInstallation> findById(final Long id) {
        return productionInstallationRepository.findById(id);
    }

    public ProductionInstallation save(final Contact contact, final ProductionInstallationCreateRequest productionInstallationCreateRequest) {
        final ProductionInstallation productionInstallation = mapToProductionInstallation(productionInstallationCreateRequest, contact);
        return productionInstallationRepository.save(productionInstallation);
    }

    private ProductionInstallation mapToProductionInstallation(final ProductionInstallationCreateRequest productionInstallationCreateRequest,
                                                               final Contact contact) {
        final ProductionInstallation productionInstallation = new ProductionInstallation();
        productionInstallation.setContact(contact);
        productionInstallation.setName(productionInstallationCreateRequest.getName());
        productionInstallation.setOutputPower(productionInstallationCreateRequest.getOutputPower());
        return productionInstallation;
    }

    public Page<ProductionInstallation> search(final ProductionInstallationSearchRequest searchRequest) {
        return productionInstallationRepository.findByCriteria(searchRequest.toSearchCriteria(), searchRequest.getPageRequest());
    }
}
