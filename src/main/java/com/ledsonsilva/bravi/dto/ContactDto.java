package com.ledsonsilva.bravi.dto;

import com.ledsonsilva.bravi.domain.enumeration.TypeContact;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContactDto {

    private Long id;

    @NotBlank
    private String contact;

    private TypeContact typeContact;

    private Long personId;

}
