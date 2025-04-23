package com.moushtario.mapstruct101.Mapper;

import com.moushtario.mapstruct101.domain.dto.PersonDto;
import com.moushtario.mapstruct101.domain.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author Youssef
 * @version 1.0
 * @created 22/04/2025
 * {@param componentModel} = "spring" allows Spring to manage the lifecycle of the mapper bean.
 * This means you can inject this mapper into other Spring components (like services or controllers) using @Autowired.
 */
@Mapper(componentModel = "spring", uses = AddressMapper.class) //uses: Because MapStruct needs to know how to map Address ↔ AddressDTO, and we delegate that job to another mapper.
public interface PersonMapper {

    PersonDto toDto(Person person);
    Person toEntity(PersonDto personDTO);

    List<PersonDto> toDtoList(List<Person> personList);

//    @Mapping(source = "person.name", target = "name")
//    @Mapping(source = "person.age", target = "age")
//    @Mapping(source = "person.id", target = "id")
//    @Mapping(source = "address.city", target = "city")
//    PersonDTO mergePersonAndAddress(Person person, AddressDTO address);
}
