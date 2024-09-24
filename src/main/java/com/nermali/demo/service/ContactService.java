package com.nermali.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nermali.demo.controller.ContactCreateRequest;
import com.nermali.demo.model.Contact;
import com.nermali.demo.repository.ContactRepository;

import jakarta.validation.Valid;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(final ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Page<Contact> findAll(final PageRequest pageRequest) {
        return contactRepository.findAll(pageRequest);
    }

    public Optional<Contact> findById(final Long id) {
        return contactRepository.findById(id);
    }

    public Contact save(final @Valid ContactCreateRequest contactCreateRequest) {
        final Contact contact = mapToContact(contactCreateRequest);
        return contactRepository.save(contact);
    }

    private Contact mapToContact(final ContactCreateRequest contactCreateRequest) {
        final Contact contact = new Contact();
        contact.setName(contactCreateRequest.getName());
        contact.setZipCode(contactCreateRequest.getZipCode());
        contact.setCity(contactCreateRequest.getCity());
        contact.setNumber(contactCreateRequest.getNumber());
        return contact;
    }
}
