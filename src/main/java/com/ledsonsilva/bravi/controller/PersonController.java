package com.ledsonsilva.bravi.controller;

import com.ledsonsilva.bravi.domain.entity.Person;
import com.ledsonsilva.bravi.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    List<Person> listPerson() {
        return this.personRepository.findAll();
    }

}
