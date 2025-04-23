package com.moushtario.mapstruct101.controller;

import com.moushtario.mapstruct101.domain.dto.PersonDto;
import com.moushtario.mapstruct101.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dell
 * @version 1.0
 * @created 22/04/2025
 */

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonDto dto) {
        return new ResponseEntity<>(personService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getById(id));
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<PersonDto> getByName(@PathVariable String name) {
        return ResponseEntity.ok(personService.getByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
