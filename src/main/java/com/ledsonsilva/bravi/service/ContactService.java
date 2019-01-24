package com.ledsonsilva.bravi.service;

import com.ledsonsilva.bravi.domain.entity.Contact;
import com.ledsonsilva.bravi.domain.entity.Person;
import com.ledsonsilva.bravi.domain.repository.ContactRepository;
import com.ledsonsilva.bravi.domain.repository.PersonRepository;
import com.ledsonsilva.bravi.dto.ContactDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PersonRepository personRepository;

    /**
     * Contact list by filter
     *
     * @param filter ContactDto
     * @param page Pageable
     * @return Page<Person>
     */
    public Page<Contact> findByFilter(ContactDto filter, Pageable page) {

        Contact contact = this.mapperFacade.map(filter, Contact.class);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        return this.contactRepository.findAll(Example.of(contact, matcher), page);

    }

    /**
     * Create Contact
     *
     * @param ContactDto ContactDto
     * @return Long
     */
    public Long create(ContactDto contactDto) {

        Optional<Person> person = this.personRepository.findById(contactDto.getPersonId());

        Contact contact = this.mapperFacade.map(contactDto, Contact.class);

        contact.setPerson(
                person.orElseThrow(
                        () -> new EntityNotFoundException("Contact with ID {" + contactDto.getPersonId() + "} Not Found")
                )
        );

        return this.contactRepository.save(contact).getId();
    }

    /**
     * Find Contact By Id
     *
     * @param id Long
     * @return Contact
     */
    public ContactDto findById(Long id) {

        Optional<Contact> contact = this.contactRepository.findById(id);

        return this.mapperFacade.map(
                contact.orElseThrow(() -> new EntityNotFoundException("Contact with ID {" + id + "} Not Found.")),
                ContactDto.class);
    }

    /**
     * Find Contact By Person Id
     *
     * @param id Long
     * @return List<Contact>
     */
    public List<ContactDto> findByPersonId(Long id) {

        return this.mapperFacade.mapAsList(
                this.contactRepository.findByPersonId(id),
                ContactDto.class);
    }

    /**
     * Contact Update
     *
     * @param ContactDto ContactDto
     * @param id        Long
     * @return ContactDto
     */
    public ContactDto update(ContactDto ContactDto, Long id) {

        Contact contact = this.contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact with ID {" + id + "} Not Found."));

        contact.setContact(ContactDto.getContact());
        contact.setType(ContactDto.getTypeContact());

        return this.mapperFacade.map(
                this.contactRepository.save(contact),
                ContactDto.class
        );

    }

    /**
     * Contact Delete
     *
     * @param id Long
     */
    public void delete(Long id) {

        this.contactRepository.deleteById(id);
    }
}
