package com.ledsonsilva.bravi.domain.enumeration;

import lombok.Getter;

@Getter
public enum TypeContact {

    EMAIL("Email"),
    PHONE("Telefone"),
    WHATS("Whatsapp");

    private String name;

    TypeContact(String name) {
        this.name = name;
    }

}
