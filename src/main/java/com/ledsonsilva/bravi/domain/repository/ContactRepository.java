package com.ledsonsilva.bravi.domain.repository;

import com.ledsonsilva.bravi.domain.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByPersonId(Long id);
}
