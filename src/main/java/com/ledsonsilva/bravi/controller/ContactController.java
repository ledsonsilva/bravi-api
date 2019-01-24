package com.ledsonsilva.bravi.controller;

import com.ledsonsilva.bravi.domain.entity.Contact;
import com.ledsonsilva.bravi.dto.ContactDto;
import com.ledsonsilva.bravi.service.ContactService;
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
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private MapperFacade mapperFacade;

    @GetMapping
    ResponseEntity<List<ContactDto>> findByFilter(@ModelAttribute ContactDto filter, Pageable page) {

        Page<Contact> contactPage = this.contactService.findByFilter(filter, page);

        HttpHeaders headers = PaginationUtil
                .generatePaginationHttpHeaders(contactPage);

        return new ResponseEntity<>(this.mapperFacade.mapAsList(contactPage.getContent(), ContactDto.class),
                headers,
                HttpStatus.OK);

    }

    @PostMapping
    ResponseEntity<Long> create(@Validated @RequestBody ContactDto contactDto) {

        return new ResponseEntity<>(this.contactService.create(contactDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{contactId}")
    ResponseEntity<ContactDto> findById(@PathVariable("contactId") Long id) {

        return new ResponseEntity<>(this.contactService.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{contactId}")
    ResponseEntity<ContactDto> update(@PathVariable("contactId") Long id, @RequestBody ContactDto contactDto) {

        return new ResponseEntity<>(this.contactService.update(contactDto, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{contactId}")
    void delete(@PathVariable("contactId") Long id) {

        this.contactService.delete(id);
    }
}
