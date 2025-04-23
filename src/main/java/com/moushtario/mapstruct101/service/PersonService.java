package com.moushtario.mapstruct101.service;

import com.moushtario.mapstruct101.domain.dto.PersonDto;

import java.util.List;

/**
 * @author dell
 * @version 1.0
 * @created 23/04/2025
 */
public interface PersonService {
    PersonDto create(PersonDto dto);
    List<PersonDto> getAll();
    PersonDto getById(Long id);
    PersonDto getByName(String name);
    void delete(Long id);
}

