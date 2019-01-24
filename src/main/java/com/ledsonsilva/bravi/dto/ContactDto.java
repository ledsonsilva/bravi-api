package com.ledsonsilva.bravi.dto;

import com.ledsonsilva.bravi.domain.enumeration.TypeContact;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ContactDto {

    private Long id;

    @NotBlank
    private String contact;

    @NotBlank
    private TypeContact typeContact;

    @NotBlank
    private Long personId;

}
