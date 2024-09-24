package com.nermali.demo.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nermali.demo.model.Contact;
import com.nermali.demo.model.ProductionInstallation;
import com.nermali.demo.service.ContactService;
import com.nermali.demo.service.ProductionInstallationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/production-installation")
public class ProductionInstallationController {

    private final ProductionInstallationService productionInstallationService;
    private final ContactService contactService;

    public ProductionInstallationController(final ProductionInstallationService productionInstallationService, final ContactService contactService) {
        this.productionInstallationService = productionInstallationService;
        this.contactService = contactService;
    }

    @GetMapping(params = { "page", "size" })
    public Page<ProductionInstallation> getProductionInstallations(@RequestParam Integer page, @RequestParam Integer size) {
        return productionInstallationService.findAll(PageRequest.of(page, size));
    }

    @PostMapping("/search")
    public Page<ProductionInstallation> searchProductionInstallations(@RequestBody ProductionInstallationSearchRequest searchRequest) {
        return productionInstallationService.search(searchRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductionInstallation> getProductionInstallation(@PathVariable Long id) {
        Optional<ProductionInstallation> productionInstallation = productionInstallationService.findById(id);
        return ResponseEntity.of(productionInstallation);
    }

    @PostMapping
    public ResponseEntity createProductionInstallation(@RequestBody @Valid ProductionInstallationCreateRequest productionInstallation) {
        Optional<Contact> contact = contactService.findById(productionInstallation.getContactId());
        if (contact.isEmpty()) {
            return ResponseEntity.status(NOT_FOUND).body("Contact not found");
        }
        return ResponseEntity.ofNullable(productionInstallationService.save(contact.get(), productionInstallation));
    }

}
