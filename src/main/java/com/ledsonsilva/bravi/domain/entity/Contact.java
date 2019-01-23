package com.ledsonsilva.bravi.domain.entity;

import com.ledsonsilva.bravi.domain.enumeration.TypeContact;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Contact {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String contact;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeContact type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

}
