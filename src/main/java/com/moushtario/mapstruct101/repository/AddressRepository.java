package com.moushtario.mapstruct101.repository;

import com.moushtario.mapstruct101.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author dell
 * @version 1.0
 * @created 23/04/2025
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByStreet(String Street);

    Optional<Address> findByCity(String city);

    Optional<Address> findByStreetAndCity(String street, String city);

}
