package com.moushtario.mapstruct101.Mapper;

import com.moushtario.mapstruct101.domain.dto.AddressDto;
import com.moushtario.mapstruct101.domain.entity.Address;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author dell
 * @version 1.0
 * @created 23/04/2025
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity(AddressDto addressDto);
    AddressDto toDto(Address address);

    List<AddressDto> toDtoList(List<Address> addressList);
}
