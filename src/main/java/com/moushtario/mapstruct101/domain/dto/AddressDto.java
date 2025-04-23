package com.moushtario.mapstruct101.domain.dto;

import lombok.*;


/**
 * DTO for {@link com.moushtario.mapstruct101.domain.entity.Address}
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto  {
    String street;
    String city;
    String zipCode;

}