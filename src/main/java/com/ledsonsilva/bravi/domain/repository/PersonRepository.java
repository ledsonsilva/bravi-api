package com.ledsonsilva.bravi.domain.repository;

import com.ledsonsilva.bravi.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
