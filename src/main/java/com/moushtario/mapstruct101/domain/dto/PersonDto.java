package com.moushtario.mapstruct101.domain.dto;

import com.moushtario.mapstruct101.domain.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link Person} entity.
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String name;
    private int age;

    private AddressDto address;
}