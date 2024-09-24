package com.nermali.demo.controller;

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
import com.nermali.demo.service.ContactService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(final ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(params = { "page", "size" })
    public Page<Contact> getContacts(@RequestParam Integer page, @RequestParam Integer size) {
        return contactService.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        Optional<Contact> contact = contactService.findById(id);
        return ResponseEntity.of(contact);
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody @Valid ContactCreateRequest contact) {
        return ResponseEntity.ofNullable(contactService.save(contact));
    }
}
