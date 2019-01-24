package com.ledsonsilva.bravi.service;

import com.ledsonsilva.bravi.domain.entity.Person;
import com.ledsonsilva.bravi.domain.repository.PersonRepository;
import com.ledsonsilva.bravi.dto.PersonDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private PersonRepository personRepository;

    /**
     * Person list by filter
     *
     * @param filter PersonDto
     * @param page   Pageable
     * @return Page<Person>
     */
    public Page<Person> findByFilter(PersonDto filter, Pageable page) {

        Person person = this.mapperFacade.map(filter, Person.class);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        return this.personRepository.findAll(Example.of(person, matcher), page);

    }

    /**
     * Create Person
     *
     * @param personDto PersonDto
     * @return Long
     */
    public Long create(PersonDto personDto) {

        Person person = this.mapperFacade.map(personDto, Person.class);
        return this.personRepository.save(person).getId();
    }

    /**
     * Find Person By Id
     *
     * @param id Long
     * @return Person
     */
    public PersonDto findById(Long id) {

        Optional<Person> person = this.personRepository.findById(id);

        return this.mapperFacade.map(
                person.orElseThrow(() -> new EntityNotFoundException("Person with ID {" + id + "} Not Found.")),
                PersonDto.class);
    }

    /**
     * Person Update
     *
     * @param personDto PersonDto
     * @param id        Long
     * @return PersonDto
     */
    public PersonDto update(PersonDto personDto, Long id) {

        Person person = this.personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person with ID {" + id + "} Not Found."));

        person.setName(personDto.getName());

        return this.mapperFacade.map(
                this.personRepository.save(person),
                PersonDto.class
        );

    }

    /**
     * Person Delete
     *
     * @param id Long
     */
    public void delete(Long id) {

        this.personRepository.deleteById(id);
    }
}
