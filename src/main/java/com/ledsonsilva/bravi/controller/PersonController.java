package com.ledsonsilva.bravi.controller;

import com.ledsonsilva.bravi.domain.entity.Person;
import com.ledsonsilva.bravi.dto.PersonDto;
import com.ledsonsilva.bravi.service.PersonService;
import com.ledsonsilva.bravi.util.PaginationUtil;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private MapperFacade mapperFacade;

    @GetMapping
    ResponseEntity<List<PersonDto>> findByFilter(@ModelAttribute PersonDto filter, Pageable page) {

        Page<Person> personPage = this.personService.findByFilter(filter, page);

        HttpHeaders headers = PaginationUtil
                .generatePaginationHttpHeaders(personPage);

        return new ResponseEntity<>(this.mapperFacade.mapAsList(personPage.getContent(), PersonDto.class),
                headers,
                HttpStatus.OK);

    }

    @PostMapping
    ResponseEntity<Long> create(@Validated @RequestBody PersonDto personDto) {

        return new ResponseEntity<>(this.personService.create(personDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{personId}")
    ResponseEntity<PersonDto> findById(@PathVariable("personId") Long id) {

        return new ResponseEntity<>(this.personService.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{personId}")
    ResponseEntity<PersonDto> update(@PathVariable("personId") Long id, @RequestBody PersonDto personDto) {

        return new ResponseEntity<>(this.personService.update(personDto, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{personId}")
    void delete(@PathVariable("personId") Long id) {

        this.personService.delete(id);
    }
}
