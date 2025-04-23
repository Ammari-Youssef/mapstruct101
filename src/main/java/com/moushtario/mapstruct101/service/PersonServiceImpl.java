package com.moushtario.mapstruct101.service;

import com.moushtario.mapstruct101.Mapper.PersonMapper;
import com.moushtario.mapstruct101.domain.dto.PersonDto;
import com.moushtario.mapstruct101.domain.entity.Person;
import com.moushtario.mapstruct101.exception.ResourceNotFoundException;
import com.moushtario.mapstruct101.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dell
 * @version 1.0
 * @created 22/04/2025
 */
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    @Override
    public PersonDto create(PersonDto dto) {
        Person person = personMapper.toEntity(dto);
        return personMapper.toDto(personRepository.save(person));
    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        return personMapper.toDtoList(personList);
    }

    @Override
    public PersonDto getById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
    }

    @Override
    public PersonDto getByName(String name) {
        return personRepository.findByName(name)
                .map(personMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with name: " + name));
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
        if (!personRepository.existsById(id)) {
            throw new ResourceNotFoundException("Person not found with id: " + id);
        }
    }
}
