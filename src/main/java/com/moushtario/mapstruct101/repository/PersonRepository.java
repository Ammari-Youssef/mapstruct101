package com.moushtario.mapstruct101.repository;

import com.moushtario.mapstruct101.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Youssef
 * @version 1.0
 * @created 22/04/2025
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);
}
