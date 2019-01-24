package com.ledsonsilva.bravi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PersonDto {

    private Long id;

    @NotBlank
    private String name;

}
