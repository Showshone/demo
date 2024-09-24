package com.nermali.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nermali.demo.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
